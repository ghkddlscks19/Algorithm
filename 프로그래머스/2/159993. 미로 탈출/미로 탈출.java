import java.util.*;
class Point{
    int x;
    int y;
    int distance;
    
    public Point(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
class Solution {
    static int n,m;
    static int start_x, start_y;
    static int lever_x, lever_y;
    static int exit_x, exit_y;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];
    
    static int exitBFS(int x, int y, char maze[][]){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        queue.add(new Point(x,y,0));
        visited[x][y] = true;
        
        
        while(!queue.isEmpty()){
            Point curr = queue.poll(); 
            
            if(curr.x == exit_x && curr.y == exit_y){
                return curr.distance;
            }
            for(int i =0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m
                   && visited[nx][ny] == false && maze[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, curr.distance+1));
                }
            }
        }
        return -1;
    }
    
    public int leverBFS(int x, int y, char[][] maze){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        queue.add(new Point(x, y, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            
            if(curr.x == lever_x && curr.y == lever_y){
                return curr.distance;
            }
            for(int i =0; i<4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m
                   && visited[nx][ny] == false && maze[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, curr.distance+1));
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        char maze[][] = new char[n][m];
        
        for(int i =0; i<n; i++){
            maze[i] = maps[i].toCharArray();
        }
        
        
        //시작, 레버, 출구 위치 저장
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(maze[i][j] == 'S'){
                    start_x = i;
                    start_y = j;
                }else if(maze[i][j] == 'L'){
                    lever_x = i;
                    lever_y = j;
                }else if(maze[i][j] == 'E'){
                    exit_x = i;
                    exit_y = j;
                }
            }
        }
       
        int answer = 0;
        int lever_bfs = leverBFS(start_x, start_y, maze);
        int exit_bfs = exitBFS(lever_x, lever_y, maze);
        
        if(lever_bfs == -1 || exit_bfs == -1){
            answer = -1;
        }else{
            answer = lever_bfs + exit_bfs;
        }
        return answer;
    }
}