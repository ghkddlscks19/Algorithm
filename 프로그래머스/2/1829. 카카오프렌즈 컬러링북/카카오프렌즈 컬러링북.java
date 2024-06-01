class Solution {
    
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    
    //영역의 갯수
    static int numberOfArea ;
    //가장 큰 영역
    static int maxSizeOfOneArea;
    //영역의 크기를 셀 변수
    static int size;
    //방문
    static boolean visited[][];
    //picture 전역변수화
    static int Picture[][];
    
    static void dfs(int x, int y){
        if(visited[x][y]) return;
        
        //방문처리
        visited[x][y] = true;
        size++;
        //갈 수 있는 곳 전부 방문
        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0 && nx<Picture.length && ny>=0 && ny<Picture[0].length
              && Picture[x][y] == Picture[nx][ny] && !visited[nx][ny]){
                dfs(nx,ny);
            }
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        Picture = picture;
        visited = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        size = 0;
        
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(Picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    dfs(i,j);
                }
                if(maxSizeOfOneArea < size){
                    maxSizeOfOneArea = size;
                }
                size = 0;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}