import java.util.*;
import java.io.*;
public class Main{
  static int N, L, R;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    arr = new int[N][N];

    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(solve() + "");
    bw.flush();
    bw.close();
  }

  static int solve() {
    int days = 0;

    while(true) {
      boolean isMoved = false;
      visited = new boolean[N][N];

      for(int i =0; i<N; i++) {
        for(int j =0; j<N; j++) {
          if(!visited[i][j]) {
            if(bfs(i, j)) isMoved = true;
          }
        }
      }

      if(!isMoved) break;
      days++;
    }

    return days;
    
  }

  static boolean bfs(int x, int y) {
    Deque<Point> q = new ArrayDeque<>();
    List<Point> union = new ArrayList<>();
    q.offer(new Point(x, y));
    union.add(new Point(x, y));
    visited[x][y] = true;

    int sum = arr[x][y];

    while(!q.isEmpty()) {
      Point curr = q.poll();
      
      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if(visited[nx][ny]) continue;
        
        int diff = Math.abs(arr[curr.x][curr.y] - arr[nx][ny]);

        if(diff >= L && diff <= R) {
          visited[nx][ny] = true;
          q.offer(new Point(nx, ny));
          union.add(new Point(nx, ny));
          sum += arr[nx][ny];
        }      
      }
    }

    if(union.size() > 1) {
      int avg = sum / union.size();
      for(Point p : union) {
        arr[p.x][p.y] = avg;
      }
      return true;
    }

    return false;
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
