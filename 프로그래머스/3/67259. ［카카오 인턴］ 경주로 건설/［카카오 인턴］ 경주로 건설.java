import java.util.*;
class Solution {
    //시계방향으로 확인
    static int dx[] = {-1,0,1,0}, dy[] = {0,1,0,-1};
    //방문여부 및 현재까지 비용 저장
    static int visited[][][];
    //board 길이 저장
    static int n;
    //좌표값, 방향, 비용을 저장하는 클래스
    static class Node{
        int x, y, direction, cost;
        
        public Node(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    public int bfs(int x, int y, int board[][]){
        //4방향에서 오는 값을 다 확인할 수 있게 하기 위해 3차원 배열 사용
        visited = new int[n][n][4];
        //최소비용을 찾는 문제이므로 일단 최대값으로 다 채움
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        //시작은 방향이 없으니까 -1로 지정했음
        queue.add(new Node(x, y, -1, 0));
        
        //최소 비용 넣어 둘 변수
        int min_cost = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            //갈 수 있는 방향 순회
            for(int i =0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] == 0){
                    //다음 비용은 현재 값으로 초기화 하고 밑에 if문에 따라 값 추가
                    int next_cost = now.cost;
                    
                    //시작이거나 진행방향이 같을 때
                    if(now.direction == -1 || now.direction == i){
                        next_cost+=100;
                    }else{
                        next_cost+=600;
                    }
                    
                    //방문배열에 있는 값보다 비용이 적을 때
                    if(visited[nx][ny][i] >= next_cost){
                        queue.add(new Node(nx, ny, i, next_cost));
                        visited[nx][ny][i] = next_cost;
                        
                        //종착지점일 때
                        if(nx == n-1 && ny == n-1){
                            min_cost = Math.min(min_cost, next_cost);
                        }
                    }
                }
            }
        }
        return min_cost;
    }
    public int solution(int[][] board) {
        n = board.length;       
        return bfs(0, 0, board);
    }
}