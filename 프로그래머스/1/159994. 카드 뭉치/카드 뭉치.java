import java.util.Queue;
import java.util.ArrayDeque;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new ArrayDeque<>();
        Queue<String> c2 = new ArrayDeque<>();
        Queue<String> g = new ArrayDeque<>();
        
        for(String s : cards1) c1.add(s);
        for(String s : cards2) c2.add(s);
        
        for(String s : goal) g.add(s);
        
        while(!g.isEmpty()){
            if(!c1.isEmpty() && c1.peek().equals(g.peek())){
                c1.poll();
                g.poll();
            }else if(!c2.isEmpty() && c2.peek().equals(g.peek())){
                c2.poll();
                g.poll();
            }else{
                return "No";
            }
        }
        
        return "Yes";
    }
}