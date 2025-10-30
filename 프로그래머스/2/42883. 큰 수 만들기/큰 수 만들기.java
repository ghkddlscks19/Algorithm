import java.util.*;
class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<number.length(); i++) {
            char curr = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < curr && cnt < k) {
                stack.pop();
                cnt++;
            }
            
            if(stack.size() < number.length() - k) stack.push(curr);
        }
        
        for(char c: stack) {
            sb.append(c - '0');
        }
        
        
        return sb.reverse().toString();
    }
}