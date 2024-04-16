class Solution {
    static int[][] computer;
    static boolean visited[];
    static void dfs(int now){
        visited[now] = true;
        //연결되어 있는지 확인
        for(int i =0; i<computer.length; i++){
            if(computer[now][i] ==1 && !visited[i]){ 
                dfs(i);
            }
        }
     }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        //배열 복사
        computer = computers;
        //방문 처리하는 배열
        visited = new boolean[n];
        
        //컴퓨터 개수만큼 반복
        for(int i =0; i<n; i++){
            //방문안했으면 dfs 호출
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
}