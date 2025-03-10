// 10^7
import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        // 빵(1) - 야채(2) - 고기(3) - 빵(1)만 포장
        Stack<Integer> stack = new Stack<>();
        int answer = 0;        
        
        for(int x : ingredient) {
            stack.push(x);
            
            if(stack.size() >= 4) {
                if((stack.get(stack.size() -4)) == 1
                  && (stack.get(stack.size() -3)) == 2
                  && (stack.get(stack.size() -2) == 3)
                  && (stack.get(stack.size() -1) == 1)) {
                    answer++;
                    for(int i =0; i<4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        

        return answer;
    }
}