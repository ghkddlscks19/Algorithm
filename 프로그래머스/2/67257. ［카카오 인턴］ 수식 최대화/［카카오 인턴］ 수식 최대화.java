import java.util.*;
class Solution {
    public long solution(String expression) {
        // 연산자 우선순위 경우의 수
        char priorities[][] = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'},
        };
        
        long max = 0;
        for(char priority[] : priorities) {
            long result = Math.abs(calc(expression, priority));
            max = Math.max(max, result);
        }
        
        return max;
    }
    
    static long calc(String expression, char priority[]) {
        List<Long> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(char c : expression.toCharArray()) {
            if(c == '*' || c == '+' || c == '-') {
                numList.add(Long.parseLong(sb.toString()));
                opList.add(c);
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        
        // 마지막 숫자
        numList.add(Long.parseLong(sb.toString()));
        
        // 연산자 우선 순위로 계산
        for(char op : priority) {
            for(int i =0; i<opList.size(); i++) {
                if(opList.get(i) == op) {                 
                    long result = operation(numList.get(i), numList.get(i+1), op);
                    numList.set(i, result);
                    opList.remove(i);
                    numList.remove(i+1);
                    i--;
                }
            }
        }
        return numList.get(0);
    }
    
    static long operation(long a, long b, char c) {
        if(c == '+') {
            return a + b;
        } else if(c == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}