import java.util.*;
import java.io.*;

public class Main{
  static int N, M;
  static char c[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static boolean visited[][][][];

  static class State {
    int rx, ry, bx, by, count;

    public State(int rx, int ry, int bx, int by, int count) {
      this.rx = rx;
      this.ry = ry;
      this.bx = bx;
      this.by = by;
      this.count = count;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    c = new char[N][M];

    for(int i =0; i<N; i++) {
      c[i] = br.readLine().toCharArray();
    }

    // R, B 위치 먼저 찾아야 함.
    int rx = 0, ry = 0, bx = 0, by = 0;

    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(c[i][j] == 'B') {
          bx = i;
          by = j;
          c[i][j] = '.';
        }
        if(c[i][j] == 'R') {
          rx = i;
          ry = j;
          c[i][j] = '.';
        }
      }
    }

    // 방문 배열 초기화
    visited = new boolean[N][M][N][M];
    
    bw.write(bfs(rx, ry, bx, by) + "");
    bw.flush();
    bw.close();
  }
  
  // 최소니까 bfs 사용
  static int bfs(int rx, int ry, int bx, int by) {
    ArrayDeque<State> q = new ArrayDeque<>();
    q.offer(new State(rx, ry, bx, by, 0));
    visited[rx][ry][bx][by] = true;

    while(!q.isEmpty()) {
      State curr = q.poll();

      if (curr.count >= 10) {
        continue;
      }

      // 빨간 구슬만 구멍에 들어갔을 때 성공
      if(c[curr.rx][curr.ry] == 'O' && c[curr.bx][curr.by] != 'O') return curr.count;

      // 4방향으로 기울여보기
      for(int i =0; i<4; i++) {
        int result[] = move(curr.rx, curr.ry, curr.bx, curr.by, i);
        int nrx = result[0];
        int nry = result[1];
        int nbx = result[2];
        int nby = result[3];
        boolean redInHole = result[4] == 1;
        boolean blueInHole = result[5] == 1;

        // 파란 구슬이 구멍에 들어가면 실패
        if(blueInHole) continue;

        // 빨간 구슬만 빠지면 성공
        if(redInHole) return curr.count + 1;

        // 방문 했으면 패스
        if(visited[nrx][nry][nbx][nby]) {
          continue;
        }

        visited[nrx][nry][nbx][nby] = true;
        q.offer(new State(nrx, nry, nbx, nby, curr.count + 1));
      }
    }
    return -1; // 10번 이내에 성공 못한 경우
  }

  static int[] move(int rx, int ry, int bx, int by, int dir) {
    boolean redInHole = false;
    boolean blueInHole = false;

    int nrx = rx;
    int nry = ry;

    // 빨간 구슬 이동 -> 벽을 만나거나, 구멍에 빠질 때 까지
    while(c[nrx + dx[dir]][nry + dy[dir]] != '#') {
      nrx += dx[dir];
      nry += dy[dir];

      if(c[nrx][nry] == 'O') {
        redInHole = true;
        break;
      }
    }

    int nbx = bx;
    int nby = by;

    // 파란 구슬 이동 -> 벽을 만나거나, 구멍에 빠질 때 까지
    while(c[nbx + dx[dir]][nby + dy[dir]] != '#') {
      nbx += dx[dir];
      nby += dy[dir];

      if(c[nbx][nby] == 'O') {
        blueInHole = true;
        break;
      }
    }

    // 두 구슬이 같은 위치에 있고, 둘 다 구멍에 빠지지 않은 경우
    if(!redInHole && !blueInHole && nrx == nbx && nry == nby) {
      int redDist = Math.abs(nrx - rx) + Math.abs(nry - ry);
      int blueDist = Math.abs(nbx - bx) + Math.abs(nby - by);

      if(redDist > blueDist) {
        nrx -= dx[dir];
        nry -= dy[dir];
      } else {
        nbx -= dx[dir];
        nby -= dy[dir];
      }
    }

    return new int[]{nrx, nry, nbx, nby, redInHole ? 1 : 0, blueInHole ? 1 : 0};
  }
}
