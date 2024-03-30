import java.util.HashMap;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //원하는 것과 수량을 담을 해시맵
        HashMap<String, Integer> wanted = new HashMap<>();
        
        for(int i =0; i<want.length; i++){
            wanted.put(want[i], number[i]);
        }
        
        for(int i =0; i<discount.length-9; i++){
            HashMap<String, Integer> hm = new HashMap<>();
            
            for(int j =i; j<i+10; j++){
                if(wanted.containsKey(discount[j])){
                    hm.put(discount[j], hm.getOrDefault(discount[j],0)+1);
                }
            }
            if(wanted.equals(hm)) answer++;
        }
        
        
        return answer;
    }
}