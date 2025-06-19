import java.util.*;
import java.io.*;
public class Main {
  static int N, M;
  static List<Point> switches[][];
  static int lights[][];
  static boolean visited[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  @SuppressWarnings("unchecked")
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
   
    switches = new ArrayList[N+1][N+1];

    for(int i =0; i<=N; i++) {
      for(int j =0; j<=N; j++) {
        switches[i][j] = new ArrayList<>();
      }
    }
    
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      // (x,y)방에서 (a,b)방 불끄기 가능
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      switches[x][y].add(new Point(a, b)); // 연결
    }

    lights = new int[N+1][N+1];
    visited = new boolean[N+1][N+1];
    bfs(1, 1);

    int result = 0;
    for(int i =1; i<=N; i++) {
      for(int j =1; j<=N; j++) {
        if(lights[i][j] == 1) result++;
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

  static void bfs(int x, int y) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y));
    visited[x][y] = true;
    lights[x][y] = 1;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      // 현재 방에 있는 스위치 전부 켜기
      for(Point sw :switches[curr.x][curr.y]) {
        if(lights[sw.x][sw.y] == 0) { // 불 안켜져있을 때
          lights[sw.x][sw.y] = 1;

          // 새로 켜진 방이 방문 가능한지 확인 (인접한 방문된 방이 있는지)
          if(!visited[sw.x][sw.y]) {
            boolean canReach = false;
            for(int i =0; i<4; i++) {
              int nx = sw.x + dx[i];
              int ny = sw.y + dy[i];
              if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
              
              if(visited[nx][ny]) {
                canReach = true;
                break;
              }
            }
              
            if(canReach) {
              q.offer(new Point(sw.x, sw.y));
              visited[sw.x][sw.y] = true;
            }
          }
        }
      }

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 1 || nx > N || ny < 1 || ny > N) continue;

        if(visited[nx][ny] || lights[nx][ny] == 0) continue;

        q.offer(new Point(nx, ny));
        visited[nx][ny] = true;
            
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
