import java.util.*;
import java.io.*;
public class Main{
  static int R, C;
  static char map[][];
  static int fireTime[][];
  static int jihoonTime[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    fireTime = new int[R][C];  
    jihoonTime = new int[R][C];  
    for(int i =0; i<R; i++) {
      Arrays.fill(jihoonTime[i], INF);
      Arrays.fill(fireTime[i], INF);
    }
    
    for(int i =0; i<R; i++) {
      String input = br.readLine();
      for(int j=0; j<C; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    // 지훈이의 시작점 구하기
    int jx = -1, jy = -1;
    ArrayDeque<int[]> fireQ = new ArrayDeque<>();
    for(int i =0; i<R; i++) {
      for(int j=0; j<C; j++) {
        if(map[i][j] == 'J') {
          jx = i;
          jy = j;
          map[i][j] = '.';
        }
        if(map[i][j] == 'F') {
          fireTime[i][j] = 0; // 초기 시간 0분
          fireQ.offer(new int[]{i, j, 0}); // x, y, 시간
        }
      }  
    }

    // 불 시간 계산
    calculateFireTime(fireQ);

    // 지훈 시간 계산
    int result = jihoonPath(jx, jy);

    if(result == -1) {
      bw.write("IMPOSSIBLE");
    } else {
      bw.write(String.valueOf(result));
    }
    bw.flush();
    bw.close();
  }
  
  // 불 확산 시간 계산
  static void calculateFireTime(ArrayDeque<int[]> fireQ) {
    while(!fireQ.isEmpty()) {
      int curr[] = fireQ.poll(); // 현재 위치
      int x = curr[0];
      int y = curr[1];
      int time = curr[2];

      // 4방향 확산
      for(int i =0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx >= 0 && nx < R && ny >= 0 && ny < C &&
           map[nx][ny] != '#' && fireTime[nx][ny] > time + 1) {
          fireTime[nx][ny] = time + 1;
          fireQ.offer(new int[]{nx, ny, time + 1});
        }
      }
    }
  }

  // 지훈 최단경로 계산
  static int jihoonPath(int startX, int startY) {
    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{startX, startY, 0});
    jihoonTime[startX][startY] = 0;

    while(!q.isEmpty()) {
      int curr[] = q.poll();
      int x = curr[0];
      int y = curr[1];
      int time = curr[2];

      if(x == 0 || x == R-1 || y == 0 || y == C-1) return time + 1;

      for(int i =0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx >= 0 && nx < R && ny >=0  && ny < C &&
          map[nx][ny] != '#' && 
          jihoonTime[nx][ny] > time + 1 &&  time + 1 < fireTime[nx][ny]) {
          q.offer(new int[]{nx, ny, time + 1});
          jihoonTime[nx][ny] = time + 1;
          }
      }
    }

    return -1; // 탈출 불가
  }
}
