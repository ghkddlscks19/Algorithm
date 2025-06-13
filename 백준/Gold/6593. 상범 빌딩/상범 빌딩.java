import java.util.*;
import java.io.*;
public class Main{
  static int L, R, C;
  static int startL, startR, startC;
  static int endL, endR, endC;
  static char map[][][];
  static int dist[][][];
  static int dr[] = {-1, 0, 1, 0, 0, 0};
  static int dc[] = {0, 1, 0, -1, 0, 0};
  static int dl[] = {0, 0, 0, 0, -1, 1};
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";
    while(!(input = br.readLine()).equals("0 0 0")) {
      StringTokenizer st = new StringTokenizer(input);

      L = Integer.parseInt(st.nextToken()); // 층 수
      R = Integer.parseInt(st.nextToken()); // 한 층의 행
      C = Integer.parseInt(st.nextToken()); // 한 층의 열

      map = new char[L][R][C];
      
      // 입력 넣기
      for(int i =0; i<L; i++) {
        for(int j =0; j<R; j++) {
          String line = br.readLine();
          for(int k =0; k<C; k++) {
            map[i][j][k] = line.charAt(k);

            // 시작 지점, 끝 지점 좌표
            if(map[i][j][k] == 'S') {
              startL = i;
              startR = j;
              startC = k;
            }

            if(map[i][j][k] == 'E') {
              endL = i;
              endR = j;
              endC = k;
            }
          }
        }

        if(i < L) br.readLine(); // 한 줄 공백
      }
      
      dist = new int[L][R][C];

      // 거리 일단 큰 값으로 채워놓기
      for(int i =0; i<L; i++) {
        for(int j =0; j<R; j++) {
          Arrays.fill(dist[i][j], INF);
        }
      }
      
      bfs(startL, startR, startC);

      if(dist[endL][endR][endC] == INF) bw.write("Trapped!");
      else bw.write("Escaped in " + dist[endL][endR][endC] + " minute(s).");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static void bfs(int l, int r, int c) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(l, r, c));
    dist[l][r][c] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      if(curr.l == endL && curr.r == endR && curr.c == endC) return;
      
      for(int i =0; i<6; i++) {
        int nl = curr.l + dl[i];
        int nr = curr.r + dr[i];
        int nc = curr.c + dc[i];

        if(nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

        if(map[nl][nr][nc] == '#' || dist[nl][nr][nc] != INF) continue;

        dist[nl][nr][nc] = dist[curr.l][curr.r][curr.c] + 1;
        q.offer(new Point(nl, nr, nc));
      }
    }
  }

  static class Point {
    int l, r, c;

    public Point(int l, int r, int c) {
      this.l = l;
      this.r = r;
      this.c = c;
    }
  }
}
