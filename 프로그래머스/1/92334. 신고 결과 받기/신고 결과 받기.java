import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //(신고 당한 사람, 신고한 사람<중복x>)
        HashMap<String, HashSet<String>> reported = new HashMap<>();
        //(신고한 사람, 받을 메일 횟수)
        HashMap<String, Integer> count = new HashMap<>();
        
        for(String s : report){
            HashSet<String> hs = new HashSet<>();
            String str[] = s.split(" ");
            String reportUser = str[0];
            String reportedUser = str[1];
            
            if(!reported.containsKey(reportedUser)){
                reported.put(reportedUser, new HashSet<>());
            }
            reported.get(reportedUser).add(reportUser);
            
        }
        
        for(String s : reported.keySet()){
            if(reported.get(s).size() >= k){
                List<String> list = new ArrayList<>(reported.get(s));
                for(String str : list){
                    count.put(str, count.getOrDefault(str, 0) + 1);
                } 
                    
            }
        }
        
        for(int i =0; i<id_list.length; i++){
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
        
     
        return answer;
    }
}