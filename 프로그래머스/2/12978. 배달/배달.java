import java.util.*;
class Solution {
    static ArrayList<Node> map[];
    static int[] dist;
    static boolean[] visited;
    static class Node{
        int v;
        int dis;
        
        public Node(int v, int dis){
            this.v = v;
            this.dis = dis;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        map = new ArrayList[N+1];
        for(int i =0; i<N+1; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int[] node : road){
            map[node[0]].add(new Node(node[1], node[2]));
            map[node[1]].add(new Node(node[0], node[2]));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) ->{
            return o1.dis - o2.dis;
        });
        
        dist[1] = 0;
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.v]) continue;
            
            visited[now.v] = true;
            for(Node next : map[now.v]){
                if(dist[next.v] > now.dis + next.dis){
                    dist[next.v] = now.dis + next.dis;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        for(int x : dist){
            if(x<=K) answer++;
        }

        return answer;
    }
}