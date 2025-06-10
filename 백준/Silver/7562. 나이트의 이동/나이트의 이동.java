import java.util.*;
import java.io.*;
public class Main{
  static int T, l;
  static int chess[][];
  static boolean visited[][];
  static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    for(int t =0; t<T; t++) {
      l = Integer.parseInt(br.readLine());
      chess = new int[l][l];
      visited = new boolean[l][l];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());
      // 시작 좌표 넣기
      bfs(startX, startY);

      st = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      bw.write(String.valueOf(chess[endX][endY]));
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }

  static void bfs(int x, int y) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y));
    visited[x][y] = true;
    
    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<8; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;

        if(visited[nx][ny]) continue;

        visited[nx][ny] = true; // 방문 처리
        chess[nx][ny] = chess[curr.x][curr.y] + 1; // 거리 1 증가
        q.offer(new Point(nx, ny)); // 큐에 추가
      }
    }
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
