import java.util.*;
import java.io.*;
public class Main{
  static int N, M, answer = 0;
  static int[][] lab;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    lab = new int[N][M];

    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M; j++) {
        lab[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    wall(0);
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  // 벽세우기
  static void wall(int count) {
    // 3개까지 세울 수 있음
    if(count == 3) {
      bfs();
      return;
    }

    // 백트래킹으로 벽 세우고 다시 원상복구
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(lab[i][j] == 0) {
          lab[i][j] = 1;
          wall(count + 1);
          lab[i][j] = 0;
        }
      }
    }
  }

  // 바이러스 확산
  static void bfs() {
    Deque<Point> q = new ArrayDeque<>();

    // 배열 복사
    int[][] temp = new int[N][M];
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        temp[i][j] = lab[i][j];

        // 바이러스 위치를 전부 큐에 넣기
        if(temp[i][j] == 2) {
          q.offer(new Point(i, j));
        }
      }
    }

    // bfs 돌리기
    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

        if(temp[nx][ny] == 0) {
          temp[nx][ny] = 2;
          q.offer(new Point(nx, ny));
        }
        
      }
    }

    answer = Math.max(answer, countSafety(temp));
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int countSafety(int[][] temp) {
    int cnt = 0;
    
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(temp[i][j] == 0) cnt++;
      }
    }

    return cnt;
  }
}
