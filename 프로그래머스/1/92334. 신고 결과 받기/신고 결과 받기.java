import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 해시맵 (신고 당한 사람, 신고한 사람(중복 X))
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        
        // 각 유저 별 신고 당한 횟수
        HashMap<String, Integer> countMap = new HashMap<>();
        
        // 신고 해시맵에 넣어 주기
        for(String rep: report) {
            String tmp[] = rep.split(" ");
            String reportUser = tmp[0]; // 신고한 사람
            String reportedUser = tmp[1]; // 신고 당한 사람
            
            // 현재 해시맵에 들어있지 않다면 초기화 해주기
            if(!reportMap.containsKey(reportedUser)) {
                reportMap.put(reportedUser, new HashSet<>());
            }
             
            reportMap.get(reportedUser).add(reportUser);
            
        }
        
        for(String reportedUser: reportMap.keySet()) {
            // 신고를 k건 이상 받았을 때 정지 사실 메일로 발송하기
            if(reportMap.get(reportedUser).size() >= k) {
                
                List<String> list = new ArrayList<>(reportMap.get(reportedUser));
                
                for(String str: list) {
                    countMap.put(str, countMap.getOrDefault(str, 0) + 1);
                }
            }
        }
        
        
        int[] answer = new int[id_list.length];
        
        for(int i =0; i<id_list.length; i++) {
            answer[i] = countMap.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}