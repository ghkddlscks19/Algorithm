import java.util.*;
class Solution {
    static class File{
        String head;
        String number;
        String tail;
        
        public File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public String getFullName(){
            return head+number+tail;
        }
    }
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        //head, number tail 추출
        for(String file : files){
            String head = "";
            String number = "";
            String tail = "";
            int i =0;
            
            //head 추출
            while(i<file.length() && !Character.isDigit(file.charAt(i))){
                head+=file.charAt(i++);
            }
            //number 추출
            while(i<file.length() && Character.isDigit(file.charAt(i))){
                number+=file.charAt(i++);
            }            
            //tail 추출
            while(i<file.length()){
                tail+=file.charAt(i++);
            }
            
            fileList.add(new File(head, number, tail));
        }
        
        Collections.sort(fileList, (o1,o2) -> {
            //head가 같을 때
            if(o1.head.equalsIgnoreCase(o2.head)){
                //numbers 오름차순으로 정렬
                return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
            }
            return o1.head.compareToIgnoreCase(o2.head);
        });
         
        String answer[] = new String[files.length];
        int i = 0;
        for(File file : fileList){
            answer[i++] = file.getFullName();
        }
        return answer;
    }
}