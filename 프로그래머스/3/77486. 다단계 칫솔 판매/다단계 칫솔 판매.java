import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //조직 관계도 저장
        HashMap<String, String> inviteMap = new HashMap<>();        
        
        for(int i =0; i<enroll.length; i++){
            inviteMap.put(enroll[i], referral[i]);
        }
        
        //구성원과 받을 금액 저장
        HashMap<String, Integer> payMap = new HashMap<>();
        
        for(int i =0; i<seller.length; i++){
            String curMember = seller[i];
            int money = amount[i] * 100;
            
            while(money > 0 && !curMember.equals("-")){ 
                //해당 인원이 받을 금액
                payMap.put(curMember, payMap.getOrDefault(curMember, 0) + money - (money/10));
                curMember = inviteMap.get(curMember);
                //다음 사람이 받을 금액은 10으로 나눠줘야함.
                money /= 10;
            }
        }
        
        int answer[] = new int[enroll.length];
        
        for(int i =0; i<enroll.length; i++){
            answer[i] = payMap.getOrDefault(enroll[i],0);
        }
        return answer;
    }
}