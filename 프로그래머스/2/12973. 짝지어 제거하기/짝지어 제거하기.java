import java.util.Stack;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        //문자열이 홀수면 불가능
        if(s.length() % 2  == 1) return 0;
        
        //push하고 peek했을 때 같은 값이면 pop
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else if(stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}