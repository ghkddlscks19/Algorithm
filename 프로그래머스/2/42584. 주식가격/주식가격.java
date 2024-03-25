import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        //0번째 원소는 비교할게 없으니 일단 push
        stack.push(0);
        
        for(int i =1; i<n; i++){
            //비어있지 않으면서 가격이 떨어졌을 때
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int pop = stack.pop();
                answer[pop] = i-pop;
            }
            stack.push(i);
        }
        
        //스택에 남아있는 것들로 주식가격 계산
        while(!stack.isEmpty()){
            int pop = stack.pop();
            //여기 개념을 몰랐음.
            answer[pop] = n-pop-1;
        }
        
        return answer;
    }
}