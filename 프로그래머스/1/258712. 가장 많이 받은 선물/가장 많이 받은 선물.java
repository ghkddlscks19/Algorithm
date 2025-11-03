import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> scoreMap = new HashMap<>(); // 점수 내역
        HashMap<String, Integer> resultMap = new HashMap<>(); // 다음달에 받는 내역
        for(String friend: friends) {
            scoreMap.put(friend, 0);
            resultMap.put(friend, 0);
        }
        
        HashMap<String, Integer> giftMap = new HashMap<>(); // 선물 내역
        for(String gift: gifts) {
            giftMap.put(gift, giftMap.getOrDefault(gift, 0) + 1);
            String[] person = gift.split(" ");
            String from = person[0]; // 주는 사람
            String to = person[1]; // 받는 사람
            scoreMap.put(from, scoreMap.get(from) + 1);
            scoreMap.put(to, scoreMap.get(to) - 1);  
        }
        
        for(int i =0; i<friends.length; i++) {
            for(int j =i+1; j<friends.length; j++) {
                String from = friends[i];
                String to = friends[j];
                
                // 선물 내역 확인을 위한 키
                String fromTo = from + " " + to;
                String toFrom = to + " " + from;
                
                // 선물 내역 있을 시 누가 많이 줬는지 카운트
                int fromToCnt = giftMap.getOrDefault(fromTo, 0);
                int toFromCnt = giftMap.getOrDefault(toFrom, 0);
                
                if(fromToCnt > toFromCnt) {
                    // from이 더 많이 줬을 때
                    resultMap.put(from, resultMap.get(from) + 1);
                } else if(toFromCnt > fromToCnt) {
                    // to가 많이 줬을 때
                    resultMap.put(to, resultMap.get(to) + 1);
                } else {
                    // 내역이 없거나 선물 준 수가 같을 때
                    int fromScore = scoreMap.get(from);
                    int toScore = scoreMap.get(to);
                    
                    if(fromScore > toScore) {
                        resultMap.put(from, resultMap.get(from) + 1);
                    } else if(toScore > fromScore) {
                        resultMap.put(to, resultMap.get(to) + 1);
                    }
                }
                
            }
        }
        
        int answer = 0;
        for(int num: resultMap.values()) {
            answer = Math.max(num, answer);
        }
        return answer;
    }
}