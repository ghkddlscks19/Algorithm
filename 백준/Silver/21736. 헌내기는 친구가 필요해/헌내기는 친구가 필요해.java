import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char c[][] = new char[N][M];

    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};

    // 입력 넣기
    for(int i =0; i<N; i++) {
      c[i] = br.readLine().toCharArray();
    }

    // 내 위치 찾기
    int mx = 0;
    int my = 0;
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(c[i][j] == 'I') {
          mx = i;
          my = j;
          break;
        }
      }
    }

    ArrayDeque<Point> queue = new ArrayDeque<>();
    boolean visited[][] = new boolean[N][M];
    queue.offer(new Point(mx, my));
    visited[mx][my] = true;

    int answer = 0;
    while(!queue.isEmpty()) {
      Point poll = queue.poll();
      int currX = poll.x;
      int currY = poll.y;

      if(c[currX][currY] == 'P') answer++;

      for(int i =0; i<4; i++) {
        int nx = currX + dx[i];
        int ny = currY + dy[i];

        if(nx >= 0 && nx < N && ny >=0 && ny < M && c[nx][ny] != 'X' && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.offer(new Point(nx, ny));
        }
      }
    }

    if(answer == 0) bw.write("TT");
    else bw.write(answer + "");
    bw.flush();
    bw.close();
  
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
