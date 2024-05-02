class Solution {
    //최대 던전 수
    static int answer = 0;
    //방문 확인 배열
    static boolean visited[];
    
    static void dfs(int k, int dungeons[][], int depth){     
        for(int i =0; i<dungeons.length; i++){
            //방문 안했고 현재 피로도가 최소 필요 피로도 이상일 때 방문
            if(!visited[i] && k>=dungeons[i][0]){
                //방문 처리
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, depth+1);
                //방문 초기화
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        return answer;
    }
}