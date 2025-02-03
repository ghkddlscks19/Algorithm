import java.util.*;
import java.io.*;

public class Main{
  static int N, M;
  static int board[][];
  static boolean[][] visited; // 방문 여부 체크
  static int answer = 0;
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 세로
    M = Integer.parseInt(st.nextToken()); // 가로

    board = new int[N][M];
    visited = new boolean[N][M];

    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken()); 
      }
    }

    for(int i =0; i<N; i++) {
      for(int j =0; j<M; j++) {
        visited[i][j] = true; // 방문처리
        backtracking(i, j, 1, board[i][j]);
        visited[i][j] = false; // 방문해제
        checkT(i, j);
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  // 방문하면서 확인하기
  static void backtracking(int x, int y, int depth, int sum) {
    if(depth == 4) { // 4칸짜리 블럭이니까 4번 방문하면 탐색 종료
      if(answer < sum) answer = sum;
      return;
    }

    for(int i =0; i<4; i++) {
      int nextX = x + dx[i]; // 다음 x좌표
      int nextY = y + dy[i]; // 다음 y좌표

      if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY]) {
        visited[nextX][nextY] = true;
        backtracking(nextX, nextY, depth + 1, sum + board[nextX][nextY]);
        visited[nextX][nextY] = false; 
      }      
    }   
  }

  // T자 모양은 따로 처리
  static void checkT(int x, int y) {
    // T자 모양은 중앙을 기준으로 상하좌우 중 3개 선택
    for(int i =0; i<4; i++) {
      int sum = board[x][y];
      boolean isValid = true;

      for(int j =0; j<4; j++) {
        if(i==j) continue;

        int nextX = x + dx[j];
        int nextY = y + dy[j];

        if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
          sum += board[nextX][nextY];     
        } else {
          isValid = false;
          break;
        }
      }
      if (isValid && answer < sum) {
          answer = sum;
      }
    }
  }
} 
