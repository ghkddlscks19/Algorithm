import java.util.*;
import java.io.*;
public class Main{
  static int K, W, H;
  static int map[][], dist[][][];
  static int horseH[] = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int horseW[] = {1, 2, 2, 1, -1, -2, -2, -1};
  static int dh[] = {-1 ,0, 1, 0};
  static int dw[] = {0, 1, 0, -1};
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    K = Integer.parseInt(br.readLine()); // 움직일 수 있는 횟수

    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken()); // 가로
    H = Integer.parseInt(st.nextToken()); // 세로

    map = new int[H][W];

    for(int i =0; i<H; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<W; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dist = new int[H][W][K+1];
    for(int i =0; i<H; i++) {
      for(int j =0; j<W; j++) {
        Arrays.fill(dist[i][j], INF);
      }
    }

    int result = bfs(0, 0);
    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

  static int bfs(int h, int w) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(h, w, 0, 0));
    dist[h][w][0] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      if(curr.h == H - 1 && curr.w == W - 1) return curr.move;

      if(curr.move > dist[curr.h][curr.w][curr.horseUsed]) continue;

      // 일반 이동
      for(int i =0; i<4; i++) {
        int nh = curr.h + dh[i];
        int nw = curr.w + dw[i];

        if(nh < 0 || nh >= H || nw < 0 || nw >= W) continue;

        if(map[nh][nw] == 1) continue;

        if(dist[nh][nw][curr.horseUsed] <= curr.move + 1) continue;

        dist[nh][nw][curr.horseUsed] = curr.move + 1;
        q.offer(new Point(nh, nw, curr.horseUsed, curr.move + 1));
      }

      // 말 이동
      if(curr.horseUsed < K) {
        for(int i =0; i<8; i++) {
          int nh = curr.h + horseH[i];
          int nw = curr.w + horseW[i];

          if(nh < 0 || nh >= H || nw < 0 || nw >= W) continue;

          if(map[nh][nw] == 1) continue;

          if(dist[nh][nw][curr.horseUsed + 1] <= curr.move + 1) continue;

          dist[nh][nw][curr.horseUsed + 1] = curr.move + 1;
          q.offer(new Point(nh, nw, curr.horseUsed + 1, curr.move + 1));
        }
      }
    }

    return -1;
  }

  static class Point {
    int h, w, horseUsed, move;

    public Point(int h, int w, int horseUsed, int move) {
      this.h = h;
      this.w = w;
      this.horseUsed = horseUsed;
      this.move = move;
    }
  }
}
