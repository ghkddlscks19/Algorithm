import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        //우선순위 큐로 정렬
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            //n번째 문자가 같은경우
            if(o1.charAt(n) == o2.charAt(n)){
                return o1.compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        });
        
        //우선순위 큐에 전부 넣기
        for(String str : strings){
            pq.add(str); 
        }
        
        int i = 0;
        //poll하면 정렬 순서대로 나옴
        while(!pq.isEmpty()){
            answer[i++] = pq.poll();
        }
        
        return answer;
    }
}