import java.util.*;
import java.io.*;
public class Main{
  static int N;
  static int[][] board;
  static int maxBlock = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, board);
    bw.write(maxBlock + "");
    bw.flush();
    bw.close();
  }

  static void dfs(int count, int[][] board) {
    if(count == 5) {
      for(int i =0; i<N; i++) {
        for(int j =0; j<N; j++) {
          maxBlock = Math.max(maxBlock, board[i][j]);
        }
      }
      return;
    }

    for(int dir = 0; dir<4; dir++) {
      int[][] nextBoard = copyArr(board);

      move(dir, nextBoard);

      dfs(count + 1, nextBoard);
    }

  }

  static void move(int dir, int[][] board) {
    Deque<Integer> q = new ArrayDeque<>();

    // 0: 상, 1: 우, 2: 하, 3: 좌
    if(dir == 0) {
      for(int j =0; j<N; j++) {
        for(int i =0; i<N; i++) {
          if(board[i][j] != 0) {
            q.offer(board[i][j]);
            board[i][j] = 0;
          }
        }
        
        int idx = 0;
        while(!q.isEmpty()) {
          int num = q.poll();

          if(board[idx][j] == 0) {
            board[idx][j] = num;
          } else if(board[idx][j] == num) {
            board[idx][j] = num * 2;
            idx++;
          } else {
            idx++;
            board[idx][j] = num;
          }
        }
      }
    } else if(dir == 1) {
      for(int i =0; i<N; i++) {
        for(int j =N-1; j>=0; j--) {
          if(board[i][j] != 0) {
            q.offer(board[i][j]);
            board[i][j] = 0;
          }
        }

        int idx = N-1;
        while(!q.isEmpty()) {
          int num = q.poll();

          if(board[i][idx] == 0) {
            board[i][idx] = num;
          } else if(board[i][idx] == num) {
            board[i][idx] = num * 2;
            idx--;
          } else {
            idx--;
            board[i][idx] = num;
          }
        }     
      }
    } else if(dir == 2) {
      for(int j =0; j<N; j++) {
        for(int i =N-1; i>=0; i--) {
          if(board[i][j] != 0) {
            q.offer(board[i][j]);
            board[i][j] = 0;
          }
        }
        
        int idx = N-1;
        while(!q.isEmpty()) {
          int num = q.poll();

          if(board[idx][j] == 0) {
            board[idx][j] = num;
          } else if(board[idx][j] == num) {
            board[idx][j] = num * 2;
            idx--;
          } else {
            idx--;
            board[idx][j] = num;
          }
        }
      }
    } else {
      for(int i =0; i<N; i++) {
        for(int j =0; j<N; j++) {
          if(board[i][j] != 0) {
            q.offer(board[i][j]);
            board[i][j] = 0;
          }
        }

        int idx = 0;
        while(!q.isEmpty()) {
          int num = q.poll();

          if(board[i][idx] == 0) {
            board[i][idx] = num;
          } else if(board[i][idx] == num) {
            board[i][idx] = num * 2;
            idx++;
          } else {
            idx++;
            board[i][idx] = num;
          }
        }     
      }      
    }
  }

  static int[][] copyArr(int[][] board) {
    int[][] copyBoard = new int[N][N];
    
    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        copyBoard[i][j] = board[i][j];
      }
    }

    return copyBoard;
  }
}
