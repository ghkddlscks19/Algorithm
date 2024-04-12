import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        //가지고 갈 수 있는 폰켓몬 수
        int takeCnt = nums.length / 2;
        //중복되는 건 제거해서 넣을 해시셋
        HashSet<Integer> mon = new HashSet<>();
        
        for(int num : nums){
            mon.add(num);
        }
            
        return answer = Math.min(takeCnt, mon.size());
    }
}