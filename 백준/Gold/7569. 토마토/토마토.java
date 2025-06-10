import java.util.*;
import java.io.*;
public class Main{
  static int M, N, H;
  static int box[][][], dist[][][];
  static int dm[] = {-1, 0, 1, 0, 0, 0}; 
  static int dn[] = {0, 1, 0, -1, 0, 0}; 
  static int dh[] = {0, 0, 0, 0, -1, 1};
  static int cnt = 0;
  static ArrayDeque<Point> q = new ArrayDeque<>();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken()); // 가로
    N = Integer.parseInt(st.nextToken()); // 세로
    H = Integer.parseInt(st.nextToken()); // 높이

    box = new int[H][N][M];

    // 입력 받기
    for(int h = 0; h < H; h++) {       
      for(int i = 0; i < N; i++) {    
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < M; j++) {  
          box[h][i][j] = Integer.parseInt(st.nextToken());
        }
      }
    }

    dist = new int[H][N][M];
    for(int h = 0; h < H; h++) {       
      for(int i = 0; i < N; i++) {    
        for(int j = 0; j < M; j++) {  
          if(box[h][i][j] == 1) { // 갈 수 있는 곳들 미리 큐에 넣어 놓기
            q.offer(new Point(h, i, j));
          }
          if(box[h][i][j] == 0) { // 토마토가 안익은 곳
            dist[h][i][j] = -1;
          }
        }
      }
    }

    bfs();
    // dist 배열의 최대값 구하기
    int max = 0;
    boolean isPossible = true;
    for(int h = 0; h < H; h++) {       
      for(int i = 0; i < N; i++) {    
        for(int j = 0; j < M; j++) {  
          if(dist[h][i][j] == -1) { // 갈 수 없는 곳이 있을 때
            isPossible = false;
          } else {
            max = Math.max(max, dist[h][i][j]);
          }
        }
      }
    }

    if(!isPossible) max = -1;
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
  }

  static void bfs() {
    while(!q.isEmpty()) { // 시작점들은 미리 넣어 줬으니 while문 부터 시작
      Point curr = q.poll();

      for(int i =0; i<6; i++) {
        int nh = curr.h + dh[i];
        int nn = curr.n + dn[i];
        int nm = curr.m + dm[i];

        // 배열을 벗어나는 경우
        if(nh < 0 || nh >= H || nn < 0 || nn >= N || nm < 0 || nm >= M) continue;

        // 토마토가 익었거나 없는 경우
        if(box[nh][nn][nm] != 0) continue;

        box[nh][nn][nm] = 1;
        dist[nh][nn][nm] = dist[curr.h][curr.n][curr.m] + 1;
        q.offer(new Point(nh, nn, nm));
      } 
    }
  }

  static class Point {
    int h, n, m;

    public Point(int h, int n, int m) {
      this.h = h;
      this.n = n;
      this.m = m;
    }
  }
}
