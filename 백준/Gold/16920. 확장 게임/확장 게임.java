import java.util.*;
import java.io.*;
public class Main{
  static int N, M, P;
  static char board[][];
  static List<ArrayDeque<Point>> players = new ArrayList<>();
  static int moves[]; // 플레이어가 이동할 수 있는 회수
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken()); // 플레이어 수 <= 9

    st = new StringTokenizer(br.readLine());

    // 플레이어 큐 초기화
    for(int i =0; i<=P; i++) {
      players.add(new ArrayDeque<>());
    }
    
    // 플레이어 한번에 이동 횟수
    moves = new int[P+1];
    for(int i =1; i<=P; i++) {
      moves[i] = Integer.parseInt(st.nextToken());
    }
    
    // 격자판 넣기
    board = new char[N][M];
    int startX = 0, startY = 0;
    for(int i =0; i<N; i++) {
      String line = br.readLine();
      for(int j =0; j<M; j++) {
        board[i][j] = line.charAt(j);
        if(board[i][j] >= '1' && board[i][j] <= '9') {
          int playerNum = board[i][j] - '0';
          players.get(playerNum).offer(new Point(i, j));
        }
      }
    }

    while(true) {
      boolean isMove = false; // 움직인 것이 있는지 확인하는 변수
      for(int i =1; i<=P; i++) {
        if(bfs(i)) isMove = true; // 움직였다고 표시
      }

      // 다 못움직이면 끝내기
      if(!isMove) break;
    }

    int result[] = new int[P+1];
    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        if(board[i][j] >= '1' && board[i][j] <= '9') {
          result[board[i][j] - '0']++;
        }
      }
    }

    for(int i =1; i<=P; i++) {
      bw.write(result[i] + " ");
    }

    bw.flush();
    bw.close();
  }

  static boolean bfs(int player) {
    if(players.get(player).isEmpty()) return false; 

    // 레벨별 bfs
    for(int t =0; t<moves[player]; t++) {
      int size = players.get(player).size();
      if(size == 0) break;
      for(int s=0; s<size; s++) {
        Point curr = players.get(player).poll();

        for(int i =0; i<4; i++) {
          int nx = curr.x + dx[i];
          int ny = curr.y + dy[i];

          if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

          if(board[nx][ny] != '.') continue;

          board[nx][ny] = (char) (player + '0'); // char로 형변환
          players.get(player).offer(new Point(nx, ny));
        }
      }
    }

    return !players.get(player).isEmpty();
  }
  
  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
