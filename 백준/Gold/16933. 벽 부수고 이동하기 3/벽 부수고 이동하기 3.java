import java.util.*;
import java.io.*;
public class Main{
  static int N, M, K;
  static int map[][];
  static int dist[][][][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); 
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken()); // 벽 부술 수 있는 횟수

    map = new int[N+1][M+1];

    // 입력 저장
    for(int i =1; i<=N; i++) {
      String line = br.readLine();
      for(int j =1; j<=M; j++) {
        map[i][j] = line.charAt(j-1) - '0';
      }
    }

    // 거리 배열에 큰 값 채워놓기
    dist = new int[N+1][M+1][K+1][2];
    for(int i =1; i<=N; i++) {
      for(int j =1; j<=M; j++) {
        for(int k =0; k<=K; k++) {
          Arrays.fill(dist[i][j][k], INF);
        }
      }
    }

    bfs(1, 1, 0, 0);

    int result = INF;
    for(int i =0; i<=K; i++) {
      for(int j =0; j<2; j++) {
        result = Math.min(result, dist[N][M][i][j]);
      }
    }

    if(result == INF) bw.write("-1");
    else bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

  static void bfs(int x, int y, int wall, int night) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, y, wall, night));
    dist[x][y][wall][night] = 1;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

        int nextNight = (curr.night + 1) % 2;

        if(map[nx][ny] == 0) { // 벽이 없음
          if(dist[nx][ny][curr.wall][nextNight] == INF) {
            dist[nx][ny][curr.wall][nextNight] = dist[curr.x][curr.y][curr.wall][curr.night] + 1;       
            q.offer(new Point(nx, ny, curr.wall, nextNight));
          }
        } else { // 벽이 있음
          if(curr.night == 0 && curr.wall < K) {
            if(dist[nx][ny][curr.wall + 1][nextNight] == INF) {
              dist[nx][ny][curr.wall + 1][nextNight] = dist[curr.x][curr.y][curr.wall][curr.night] + 1;       
              q.offer(new Point(nx, ny, curr.wall + 1, nextNight));
            }
          }
        }      
      }

      // 제자리에서 기다리기
      int nextNight = (curr.night + 1) % 2;
      if(dist[curr.x][curr.y][curr.wall][nextNight] == INF) {
        dist[curr.x][curr.y][curr.wall][nextNight] = dist[curr.x][curr.y][curr.wall][curr.night] + 1;       
        q.offer(new Point(curr.x, curr.y, curr.wall, nextNight));
      }   
    }
  }

  static class Point {
    int x, y, wall, night; // night: 0=낮, 1=밤

    public Point(int x, int y, int wall, int night) {
      this.x = x;
      this.y = y;
      this.wall = wall;
      this.night = night;
    }
  }
}
