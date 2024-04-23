import java.util.*;
class Solution {
    
    //전력망을 담을 연결리스트
    static ArrayList<Integer> graph[];
    //방문 배열
    static boolean visited[];
    
    static int dfs(int n){
        visited[n] = true;
        int cnt = 1;
        
        for(int next : graph[n]){
            if(!visited[next]){
                visited[next] = true;
                cnt+=dfs(next);
            }
        }
        
        return cnt;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];   
        for(int i =0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        //양방향 연결관계 설정
        for(int wire[] : wires){
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for(int wire[] : wires){
            //연결관계 끊기
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            
            //방문 배열은 dfs 할때마다 새롭게 선언
            visited = new boolean[n+1];
            
            //임의의 점에서 시작
            int cnt = dfs(1);
            
            // cnt = 1, (n-cnt) = 8 2개 값을 뺀 절대값과 answer 최소값 비교
            answer = Math.min(answer, Math.abs(cnt - (n-cnt)));
            
            //연결관계 다시 연결
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
            
        }
        
        return answer;
    }
}