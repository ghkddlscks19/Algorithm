import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> pwd = new HashMap<>();
        //알파벳을 해시맵에 등록하기
        int alphaNum = 1;
        for(char c = 'A'; c<='Z'; c++){
            pwd.put(String.valueOf(c), alphaNum++);
        }
        
        int index = 0;
        while(index < msg.length()){
            String w = "";
            while(index < msg.length()){
                if(!pwd.containsKey(w+msg.charAt(index))){
                    break;
                }else{
                    w += msg.charAt(index);
                }
                index++;
            }
            answer.add(pwd.get(w));
            
            if(index < msg.length()){
                pwd.put(w+msg.charAt(index), alphaNum++);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}