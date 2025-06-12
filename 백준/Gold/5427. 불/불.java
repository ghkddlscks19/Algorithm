import java.util.*;
import java.io.*;
public class Main{
  static int w, h;
  static char map[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static int fireTime[][]; // 좌표 별 불 시간
  static int sangTime[][]; // 좌표 별 상근이 시간
  static ArrayDeque<Point> fq;
  static ArrayDeque<Point> sq;
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
    
    for(int t =0; t<T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken()); // 너비
      h = Integer.parseInt(st.nextToken()); // 높이
    
      // 불, 상근 시간 초기화
      fireTime = new int[h][w];
      sangTime = new int[h][w];
      for(int i =0; i<h; i++) {
        Arrays.fill(fireTime[i], INF);
        Arrays.fill(sangTime[i], INF);
      }

      // 지도 입력
      map = new char[h][w];
      fq = new ArrayDeque<>();
      sq = new ArrayDeque<>();
      for(int i =0; i<h; i++) {
        String input = br.readLine();
        for(int j =0; j<w; j++) {
          map[i][j] = input.charAt(j);
          
          // 상근이 시작 위치, 불 시작 위치 찾기
          if(map[i][j] == '@') {
            sq.offer(new Point(i, j));
            sangTime[i][j] = 0; // 시작 시간은 0
            map[i][j] = '.'; // 상근이 위치는 빈 공간으로 바꿔놓기
          }
          if(map[i][j] == '*') {
            fq.offer(new Point(i, j));
            fireTime[i][j] = 0; // 시작 시간은 0
          }
        }
      } 

      fireBfs();

      int result = sangBfs();

      if(result == -1) bw.write("IMPOSSIBLE");
      else bw.write(String.valueOf(result));
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static void fireBfs() {
    while(!fq.isEmpty()) {
      Point curr = fq.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

        if(map[nx][ny] != '.' || fireTime[nx][ny] != INF) continue;

        fireTime[nx][ny] = fireTime[curr.x][curr.y] + 1; // 불 번지는 시간 기록
        fq.offer(new Point(nx, ny));
      }
    }
  }

  static int sangBfs() {
    while(!sq.isEmpty()) {
      Point curr = sq.poll();

      if(curr.x == 0 || curr.x == h-1 || curr.y == 0 || curr.y == w-1) {
        return sangTime[curr.x][curr.y] + 1;
      }
        
      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

        if(map[nx][ny] != '.' || sangTime[nx][ny] != INF) continue;
        
        sangTime[nx][ny] = sangTime[curr.x][curr.y] + 1;
        if(sangTime[nx][ny] >= fireTime[nx][ny]) continue;
        
        sq.offer(new Point(nx, ny));
      }
    }

    return -1;
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
