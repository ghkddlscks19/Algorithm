import java.util.*;
import java.io.*;
public class Main{
  static int n, m;
  static int board[][];
  static boolean visited[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 배열에 값 넣어놓기
    board = new int[n][m];
    for(int i =0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // bfs를 할 수 있는지 확인 후 진행
    visited = new boolean[n][m];
    int cnt = 0;
    int maxSize = 0;
    for(int i =0; i<n; i++) {
      for(int j =0; j<m; j++) {
        // 1이고 방문하지 않은 곳만 방문
        if(board[i][j] == 1 && !visited[i][j]) {
          maxSize = Math.max(maxSize, bfs(i, j));
          cnt++;
        }
      }
    } 

    bw.write(cnt + "");
    bw.newLine();
    bw.write(maxSize + "");
    bw.flush();
    bw.close();
  }
  static int bfs(int x, int y) {
    ArrayDeque<Point> q = new ArrayDeque<>(); // 큐
    q.offer(new Point(x, y));
    visited[x][y] = true;
    int size = 1; // 하나 추가했으니까 넓이는 일단 1

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        // 4방향 다 확인하기
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx >= 0 && nx < n && ny >=0 && ny < m
           && board[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true; // 방문 처리
          q.offer(new Point(nx, ny)); // 큐에 넣기
          size++; // 넓이 증가
           } 
      }
    }

    return size;
  }
  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
