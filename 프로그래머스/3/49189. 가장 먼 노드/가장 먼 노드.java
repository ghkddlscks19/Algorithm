import java.util.*;
class Solution {
    static ArrayList<Integer> graph[];
    static int dist[];
    
    public void bfs(int x){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        dist[x] = 1;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int next : graph[now]){
                if(dist[next] == 0){
                    dist[next] = dist[now]+1;
                    queue.add(next);
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        for(int i =0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int e[] : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        dist = new int[n+1];
 
        bfs(1);
        int max = 0;
        //배열에서 가장 멀리 떨어진 거리 구하기
        for(int i =1; i<n+1; i++){
            max = Math.max(max, dist[i]);
        }
        
        //가장 멀리 떨어진 거리랑 같으면 answer 증가
        for(int i =1; i<n+1; i++){
            if(max == dist[i]) answer++;
        }
        return answer;
        
        
    }
}