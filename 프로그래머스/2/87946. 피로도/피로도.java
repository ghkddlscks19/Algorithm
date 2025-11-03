class Solution {
    static int answer = 0;
    static boolean visited[];
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, int depth) {
        answer = Math.max(depth, answer);
        
        if(depth == dungeons.length) return;
        
        for(int i =0; i<dungeons.length; i++) {
            // 방문을 안했고, 현재 피로도가 최소 필요 피로도 이상이면 탐험
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1);
                visited[i] = false;
            }
        }       
    }     
}