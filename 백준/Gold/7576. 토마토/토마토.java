import java.util.*;
import java.io.*;
public class Main{
  static int N, M;
  static int board[][];
  static int dist[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static ArrayDeque<Point> q = new ArrayDeque<>();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[M][N];
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dist = new int[M][N];
    
    // 시작 할 수 있는 부분인지 확인하고 시작
    for(int i =0; i<M; i++) {
      for(int j =0; j<N; j++) {
        if(board[i][j] == 1) {
          q.offer(new Point(i, j));
        }
        if(board[i][j] == 0) {
          dist[i][j] = -1;
        }
      }
    }

    // bfs 실행
    bfs();

    // dist 배열의 최대 값 구하면 됨
    int max = 0;
    boolean isPossible = true;
    for(int i =0; i<M; i++) {
      for(int j =0; j<N; j++) {
        if(dist[i][j] < 0) { // 못가는 곳 있는 조건 체크
          max = -1;
          isPossible = false;
          break;
        } else {
          max = Math.max(max, dist[i][j]);
        }
      }

      if(!isPossible) break;
    }

    bw.write(max + "");
    bw.flush();
    bw.close();
  }

  static void bfs() {
    while(!q.isEmpty()) {
      Point curr = q.poll(); // 현재 위치

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx >= 0 && nx < M && ny >=0 && ny < N 
          && board[nx][ny] == 0 && dist[nx][ny] < 0) {
          q.offer(new Point(nx, ny));
          dist[nx][ny] = dist[curr.x][curr.y] + 1;
        }
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
