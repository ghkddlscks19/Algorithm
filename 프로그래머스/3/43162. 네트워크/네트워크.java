import java.util.*;
class Solution {
    static int[] parent;
    
    static int find(int v){
        if(parent[v] == v) return parent[v];
        return parent[v] = find(parent[v]);
    }
    
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) parent[fb] = fa;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        
        for(int i =0; i<n; i++){
            parent[i] = i;
        }
        
        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int x : parent){
            hs.add(find(x));
        }
        
        return answer = hs.size();
    }
}