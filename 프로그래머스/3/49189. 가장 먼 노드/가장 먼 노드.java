import java.util.*;
class Solution {
    
    //연결관계를 넣을 인접리스트
    static ArrayList<Integer> graph[];
    //방문 여부 및 각 노드의 최단경로 거리를 저장할 배열
    static int dist[];
    
    static void bfs(int n){
        //bfs를 위한 큐 생성
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[n] = 1;
        queue.add(n);
        
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
        
        //양방향 연결관계
        for(int e[] : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        dist = new int[n+1];
        
        //bfs를 통해 각 노드의 최단경로 거리 넣기
        bfs(1);
        
        //가장 멀리 떨어진 노드의 거리
        int max = 0;
        for(int i =0; i<dist.length; i++){
            max = Math.max(max, dist[i]);
        }
        
        //가장 멀리 떨어진 노드의 거리 개수 세기
        for(int i =0; i<dist.length; i++){
            if(max == dist[i]) answer++;
        }
        
        return answer;
    }
}