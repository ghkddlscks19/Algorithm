import java.util.*;
import java.io.*;
public class Main{
  static int N, M;
  static int map[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static boolean visited[][];
  static int max = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    // 지도 초기화
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, map[i][j]);
      }
    }

    int year = 0;
    while(true) {
      int area = 0;
      visited = new boolean[N][M];
      // 분리 되어 있는지 확인
      for(int i =0; i<N; i++) {
        for(int j =0; j<M; j++) {
          if(map[i][j] > 0 && !visited[i][j]) {
            bfs(i, j);
            area++;
          }
        }
      }

      // 빙산이 분리된 경우
      if(area >= 2) {
        bw.write(String.valueOf(year)); 
        break;
      }

      // 빙산이 분리되지 않는 경우
      if(area == 0) {
        bw.write("0"); 
        break;
      }

      // 빙산 녹이기
      int newMap[][] = new int[N][M];
      for(int i =0; i<N; i++) {
        for(int j =0; j<M; j++) {
          if(map[i][j] > 0) {
            int zeroCnt = 0;
            for(int k =0; k<4; k++) {
              int nx = i + dx[k];
              int ny = j + dy[k];

              if(nx < 0 || nx >=N || ny < 0 || ny >= M) continue;

              if(map[nx][ny] == 0) zeroCnt++; // 0일 때만 증가
            }

            newMap[i][j] = Math.max(0, map[i][j] - zeroCnt); // 0이하로 내려가면 안됨!
          }
        }
      }
      map = newMap;
      year++;
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

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

        if(map[nx][ny] == 0 || visited[nx][ny]) continue;

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
