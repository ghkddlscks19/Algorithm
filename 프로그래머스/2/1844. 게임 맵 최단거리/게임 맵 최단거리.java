import java.util.*;
class Solution {
    //해당 지점까지의 거리를 저장할 배열
    static int dist[][];
    static int answer = 0;
    static int n, m;
    //상,하,좌,우로 이동할때 사용할 배열
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void bfs(int x, int y, int maps[][]){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x,y));
        dist[x][y] = 1;
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i =0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m 
                   && dist[nx][ny] == 0 && maps[nx][ny] == 1){
                    queue.add(new Point(nx,ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
        }
        answer = dist[n-1][m-1];
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];     
        bfs(0,0,maps);
        
        if(answer == 0) return -1;
        return answer;
    }
}