import java.util.*;
class Solution {
    static ArrayList<Node> map[];
    static int dist[];
    static class Node{
        int v;
        int cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        map = new ArrayList[N+1];
        
        for(int i =0; i<N+1; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int info[] : road){
            map[info[0]].add(new Node(info[1], info[2]));
            map[info[1]].add(new Node(info[0], info[2]));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int start = 1;
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.cost - n2.cost;
        });
        
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            for(Node next : map[now.v]){
                if(dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost; 
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