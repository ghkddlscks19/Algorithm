import java.util.*;
class Solution {
    
    //정보를 저장할 클래스
    static class Node{
        int v;
        int cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    
    //연결 관계를 넣을 인접리스트
    static ArrayList<Node> graph[];
    //최소 거리를 넣을 배열
    static int dist[];
    
    static int[] dijkstra(int N, int v){
        //다익스트라 알고리즘 사용하기 위해 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        //해당 정점에서의 최소 거리 넣을 배열
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //시작 정점은 거리가 0
        pq.add(new Node(v,0));
        dist[v] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            for(Node next : graph[now.v]){
                if(dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        
        for(int i =0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        //양방향 연결 관계 설정
        for(int f[] : fares){
            graph[f[0]].add(new Node(f[1], f[2]));
            graph[f[1]].add(new Node(f[0], f[2]));
        }
        
        
        int startA[] = dijkstra(n, a);
        int startB[] = dijkstra(n, b);
        int start[] = dijkstra(n, s);
        
        int answer = Integer.MAX_VALUE;
        
        for(int i =1; i<n+1; i++){
            answer = Math.min(answer, start[i] + startA[i] + startB[i]);
        }
        
        
        return answer;
    }
}