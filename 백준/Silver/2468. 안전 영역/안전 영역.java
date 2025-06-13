import java.util.*;
import java.io.*;
public class Main{
  static int N;
  static int area[][];
  static int maxRain = 0; // 올 수 있는 최대 강수량
  static boolean visited[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine()); // 행열 개수

    area = new int[N][N]; // 영역

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        area[i][j] = Integer.parseInt(st.nextToken());
        maxRain = Math.max(maxRain, area[i][j]);
      }
    }

    int maxSafeArea = 0; // 최대 안전구역
    for(int rain =0; rain<=maxRain; rain++) {
      visited = new boolean[N][N];
      int safeArea = 0; // bfs당 안전구역 구하기

      for(int i =0; i<N; i++) {
        for(int j =0; j<N; j++) {
          if(area[i][j] > rain && !visited[i][j]) {
            bfs(i, j, rain); 
            safeArea++;
          }
        }
      }

      maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    bw.write(String.valueOf(maxSafeArea));
    bw.flush();
    bw.close();
  }

  static void bfs(int x, int y, int rain) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y));
    visited[x][y] = true;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

        if(area[nx][ny] <= rain || visited[nx][ny]) continue;

        visited[nx][ny] = true;
        q.offer(new Point(nx, ny));
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
