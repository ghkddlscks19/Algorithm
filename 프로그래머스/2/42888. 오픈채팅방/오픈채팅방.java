import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        //메시지를 담아놓을 해시맵
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");
        
        //유저를 담을 해시맵
        HashMap<String, String> user = new HashMap<>();
        for(String s : record){
            String code[] = s.split(" ");
            if(code[0].equals("Enter") || code[0].equals("Change")){
                user.put(code[1], code[2]);
            }
        }
        
        for(String s : record){
            String code[] = s.split(" ");
            if(msg.containsKey(code[0])){
                answer.add(user.get(code[1])+msg.get(code[0]));      
            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}