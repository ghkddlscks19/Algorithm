import java.util.*;
import java.io.*;
public class Main{
  static int N, M, K;
  static int map[][];
  static int dist[][][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N+1][M+1];

    for(int i =1; i<=N; i++) {
      String line = br.readLine();
      for(int j =1; j<=M; j++) {
        map[i][j] = line.charAt(j-1) - '0';
      }
    }

    dist = new int[N+1][M+1][K+1];
    for(int i =1; i<=N; i++) {
      for(int j =1; j<=M; j++) {
        Arrays.fill(dist[i][j] , INF);
      }
    }

    bfs(1, 1, 0);

    int result = INF;
    for(int i =0; i<=K; i++) {
      result = Math.min(result, dist[N][M][i]);
    }

    if(result == INF) bw.write("-1");
    else bw.write(String.valueOf(result + 1));
    bw.flush();
    bw.close();
  }
  static void bfs(int x, int y, int wall) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y, wall));
    dist[x][y][wall] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

        if(map[nx][ny] == 0) {
          if(dist[nx][ny][curr.wall] > dist[curr.x][curr.y][curr.wall] + 1) {
            dist[nx][ny][curr.wall] = dist[curr.x][curr.y][curr.wall] + 1;
            q.offer(new Point(nx, ny, curr.wall));
          }
        } else if(map[nx][ny] == 1) {
          if(curr.wall + 1 <= K && dist[nx][ny][curr.wall + 1] > dist[curr.x][curr.y][curr.wall] + 1) {
            dist[nx][ny][curr.wall + 1] = dist[curr.x][curr.y][curr.wall] + 1;
            q.offer(new Point(nx, ny, curr.wall + 1));
          }
        }
      }
    }
  }
  
  static class Point {
    int x, y, wall;

    public Point(int x, int y, int wall) {
      this.x = x;
      this.y = y;
      this.wall = wall;
    }
  }
  
}
