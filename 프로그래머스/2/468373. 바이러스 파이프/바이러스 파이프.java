import java.util.*;
class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    List<int[]> nums = new ArrayList<>();
    boolean[][] visited;
    public int solution(int n, int infection, int[][] edges, int k) {
        for(int i =0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향 연결
        for(int[] edge: edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
              
        permutation(new int[k], 0, k);
        
        int answer = 0;
        
        for(int[] order: nums) {
            visited = new boolean[n+1][4];
            visited[infection][0] = true;
            
            for(int type: order) {
                bfs(n, type);           
            }
            
            int num = 0;
            for(int i =1; i<=n; i++) {
                for(int j =1; j<=3; j++) {
                    if(visited[i][j] == true) {
                        num++;
                        break;
                    }
                }
            }
            
            answer = Math.max(num, answer);
        }
        
        return answer;
    }
    
    void bfs(int n, int type) {
        Deque<int[]> q = new ArrayDeque<>();
        for(int i =1; i<=n; i++) {
            for(int j =0; j<4; j++) {
                if(visited[i][j]) {
                    q.offer(new int[]{i, j});
                    break;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for(int[] next: graph.get(curr[0])) {
                if(type == next[1] && !visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.offer(new int[]{next[0], next[1]});
                }
            }
        }

    }
    
    // 가능한 순열 타입 뽑기
    void permutation(int curr[], int depth, int k) {
        if(depth == k) {
            nums.add(curr.clone());
            return;
        }
        
        for(int type =1; type<=3; type++) {
            curr[depth] = type;
            permutation(curr, depth + 1, k);
        }
    }
}