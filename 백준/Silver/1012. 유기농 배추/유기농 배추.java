import java.util.*;
import java.io.*;

public class Main {
  static int dx[] = {-1, 0, 1, 0}; // 상, 우, 하, 좌
  static int dy[] = {0, 1, 0, -1};

  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

      for (int v = 0; v < T; v++) {   
          StringTokenizer st = new StringTokenizer(br.readLine());
          int M = Integer.parseInt(st.nextToken()); // 가로 (열)
          int N = Integer.parseInt(st.nextToken()); // 세로 (행)
          int K = Integer.parseInt(st.nextToken()); // 배추 개수

          int arr[][] = new int[N][M]; // 배추밭 배열
          boolean visited[][] = new boolean[N][M]; // 방문 여부

          // 배추 심어진 위치 입력
          for (int i = 0; i < K; i++) {
              st = new StringTokenizer(br.readLine());
              int Y = Integer.parseInt(st.nextToken());
              int X = Integer.parseInt(st.nextToken());
              arr[X][Y] = 1; // 배추가 있는 위치
          }

          int count = 0; // 배추 군집 개수

          // 전체 배열을 탐색하며 BFS 실행
          for (int i = 0; i < N; i++) {
              for (int j = 0; j < M; j++) {
                  if (arr[i][j] == 1 && !visited[i][j]) { 
                    // BFS 시작
                    ArrayDeque<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i, j));
                    visited[i][j] = true;

                      while (!queue.isEmpty()) {
                          Point poll = queue.poll(); // 현재 위치

                          for (int d = 0; d < 4; d++) {
                              int nx = poll.x + dx[d];
                              int ny = poll.y + dy[d];

                              if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                  if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                                      visited[nx][ny] = true;
                                      queue.add(new Point(nx, ny));
                                  }
                              }
                          }
                      }

                      count++; // 하나의 군집 탐색 완료
                  }
              }
          }

          bw.write(count + "\n");
      }

      bw.flush();
      bw.close();
      br.close();
  }

  static class Point {
      int x;
      int y;

      public Point(int x, int y) {
          this.x = x;
          this.y = y;
        }
    }
}
