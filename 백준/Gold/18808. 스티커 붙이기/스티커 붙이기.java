import java.util.*;
import java.io.*;
public class Main{
  static int[][] notebook;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    notebook = new int[N][M];

    for(int i =0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      int R = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      int[][] sticker = new int[R][C];
      for(int r =0; r<R; r++) {
        st = new StringTokenizer(br.readLine());
        for(int c =0; c<C; c++) {
          sticker[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      // 0, 90, 180, 270 4번 회전 시도
      for(int rot =0; rot<4; rot++) {
        boolean attached = false;
        int currR = sticker.length;
        int currC = sticker[0].length;
        
        // 모든 칸 순회하면서 스티커 좌상단 맞춰보기
        for(int r =0; r<=N-currR; r++) {
          for(int c =0; c<=M-currC; c++) {
            if(canAttached(r, c, sticker)) {
              attach(r, c, sticker);
              attached = true;
              break;
            }
          }
          if(attached) break;           
        }
        if(attached) break;           
        sticker = rotate(sticker);    
      }
    }

    bw.write(countSticker(notebook) + "");
    bw.flush();
    bw.close();
  }
  
  // 스티커를 붙일 수 있나 확인
  static boolean canAttached(int startR, int startC, int[][] sticker) {
    for(int r =0; r<sticker.length; r++) {
      for(int c =0; c<sticker[0].length; c++) {
        // 스티커 칸이 1인데 노트북에 이미 스티커가 붙어있는 경우
        if(sticker[r][c] == 1 && notebook[startR + r][startC + c] == 1) {
          return false;
        }
      }
    }

    return true;
  }

  // 스티커 붙이기
  static void attach(int startR, int startC, int[][] sticker) {
    for(int r =0; r<sticker.length; r++) {
      for(int c =0; c<sticker[0].length; c++) {
        if(sticker[r][c] == 1) {
          notebook[startR + r][startC + c] = 1;
        }
      }
    }
  }

  // 회전 함수
  static int[][] rotate(int[][] sticker) {
    int r = sticker.length;
    int c = sticker[0].length;

    int[][] arr = new int[c][r];

    for(int i =0; i<r; i++) {
      for(int j =0; j<c; j++) {
        arr[j][r-1-i] = sticker[i][j];
      }
    }

    return arr;
  }

  // 스티커 세기
  static int countSticker(int[][] notebook) {
    int count = 0;
    for(int i =0; i<notebook.length; i++) {
      for(int j =0; j<notebook[0].length; j++) {
        if(notebook[i][j] == 1) {
          count++;
        }
      }
    }

    return count;
  }
}
