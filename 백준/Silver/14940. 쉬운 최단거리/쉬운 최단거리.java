import java.util.*;
import java.io.*;
public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int arr[][] = new int[n][m];
    int dist[][] = new int[n][m]; // 거리를 저장할 배열
    int startX = 0, startY = 0;
    
    // 초기화: 갈 수 있는 땅은 -1로 표시 (아직 방문하지 않음)
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if(arr[i][j] == 1) dist[i][j] = -1; // 갈 수 있는 땅은 -1로 초기화
        else if(arr[i][j] == 2) {
          startX = i;
          startY = j;
          arr[i][j] = 1; // 시작점도 갈 수 있는 땅으로 변경
          dist[i][j] = 0; // 시작점 거리는 0
        }
      }
    }
    
    // 최단거리 bfs로 구현
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(startX, startY));
    
    while(!q.isEmpty()) {
      Point poll = q.poll();
      
      for(int i = 0; i < 4; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && 
           dist[nx][ny] == -1) { // 아직 방문하지 않은 갈 수 있는 땅
          dist[nx][ny] = dist[poll.x][poll.y] + 1;
          q.offer(new Point(nx, ny));
        }
      }
    }
    
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        bw.write(dist[i][j] + " ");
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
  
  static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}