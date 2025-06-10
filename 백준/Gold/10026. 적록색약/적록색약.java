import java.util.*;
import java.io.*;
public class Main{
  static int N;
  static char board[][];
  static boolean visited[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static int cnt1 = 0, cnt2 = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine()); // 크기

    board = new char[N][N]; // 그림
    
    for(int i =0; i<N; i++) {
      board[i] = br.readLine().toCharArray();
    }

    // bfs를 레드, 블루, 그린, 적록 4개 버전
    // R: 레드, B: 블루, G: 그린, E: 적록색약
    visited = new boolean[N][N];
    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(!visited[i][j] && board[i][j] == 'R') {
          bfs(i, j, 'R');
          cnt1++;
        }
        if(!visited[i][j] && board[i][j] == 'G') {
          bfs(i, j, 'G');
          cnt1++;
        }
        if(!visited[i][j] && board[i][j] == 'B') {
          bfs(i, j, 'B');
          cnt1++;  
        }
      }
    }

    visited = new boolean[N][N];
    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(!visited[i][j] && (board[i][j] == 'R' || board[i][j] == 'G')) {
          bfs(i, j, 'E');
          cnt2++;
        }
        if(!visited[i][j] && board[i][j] == 'B') {
          bfs(i, j, 'B');
          cnt2++;
        }
      }
    }

    bw.write(cnt1 + " " + cnt2);
    bw.flush();
    bw.close();
  }

    static void bfs(int x, int y, char category) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    
    // 초기값 넣고 방문 처리
    q.offer(new Point(x, y));
    visited[x][y] = true;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
          if(category == 'E') { // 적록색약
            if(board[nx][ny] == 'R' || board[nx][ny] == 'G') { // 적록
              visited[nx][ny] = true;
              q.offer(new Point(nx, ny));
            }
          } else { // 일반
            if(board[nx][ny] == category) { // R, G, B
              visited[nx][ny] = true;
              q.offer(new Point(nx, ny));
            } 
          }
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
