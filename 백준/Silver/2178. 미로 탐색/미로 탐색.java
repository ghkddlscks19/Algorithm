import java.util.*;
import java.io.*;
public class Main{
  static int N, M;
  static int board[][], dist[][];
  static boolean visited[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    for(int i =0; i<N; i++) {
      String input = br.readLine();
      for(int j =0; j<M; j++) {
        board[i][j] = input.charAt(j) - '0';
      }
    }

    visited = new boolean[N][M];
    dist = new int[N][M]; // 각 좌표의 걸리는 거리를 저장하는게 핵심!
    for(int i =0; i<N; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    int answer = bfs(0, 0);
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
  static int bfs(int x, int y) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y));
    visited[x][y] = true;
    dist[x][y] = 1;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx >= 0 && nx < N && ny >=0 && ny < M 
          && board[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          q.offer(new Point(nx, ny));
          // 현재 좌표에 있는 거리 값과 이전 좌표 거리 + 1 중 최소 거리를 사용
          dist[nx][ny] = Math.min(dist[curr.x][curr.y] + 1, dist[nx][ny]);
          }      
      }
    }
    return dist[N-1][M-1];
  }
  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
