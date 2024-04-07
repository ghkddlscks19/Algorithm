import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //조직 관계도 설정
        HashMap<String, String> referMap = new HashMap<>();
        
        for(int i =0; i<enroll.length; i++){
            referMap.put(enroll[i], referral[i]);
        }
        
        //판매원 당 총 번 돈 저장
        HashMap<String, Integer> totalMap = new HashMap<>();
        for(int i =0; i<seller.length; i++){
            String currMember = seller[i];
            int money = amount[i]*100;
            
            while(money>0 && !currMember.equals("-")){
                totalMap.put(currMember, totalMap.getOrDefault(currMember, 0) + money-(money/10));
                currMember = referMap.get(currMember);
                money/=10;
            }
            
        }
        
        int answer[] = new int[enroll.length];
        for(int i =0; i<answer.length; i++){
            answer[i] = totalMap.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}