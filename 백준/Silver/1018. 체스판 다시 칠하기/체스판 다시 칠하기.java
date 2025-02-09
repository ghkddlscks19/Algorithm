import java.util.*;
import java.io.*;

// 반복문 많이 써도 될듯
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String board[] = new String[N];

    for(int i =0; i<N; i++) {
      board[i] = br.readLine();
    }

    // 체스판 자르기
    int min = Integer.MAX_VALUE; 
    for(int i =0; i<=N-8; i++) {
      for(int j =0; j<=M-8; j++) {
        // 현 체스판의 최소비용 구하기
        int currMin = solution(i, j, board);

        // 전체 최적의 값과 비교하여 갱신하기
        if(currMin < min) min = currMin;
      }
    } 
    bw.write(min + "");
    bw.flush();
    bw.close();
  }

  public static int solution(int startRow, int startCol, String board[]) {
    int blackStart = 0; // 'B'로 시작하는 체스판으로 바꿀 경우의 비용
    int whiteStart = 0; // 'W'로 시작하는 체스판으로 바꿀 경우의 비용

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            char current = board[startRow + i].charAt(startCol + j);

            // (i + j) % 2 == 0 : 시작 색과 같아야 함
            if ((i + j) % 2 == 0) {
                if (current != 'B') blackStart++;  // 'B'로 시작하는 체스판
                if (current != 'W') whiteStart++;  // 'W'로 시작하는 체스판
            }
            // (i + j) % 2 == 1 : 시작 색과 반대여야 함
            else {
                if (current != 'W') blackStart++;
                if (current != 'B') whiteStart++;
            }
        }
    }
    return Math.min(blackStart, whiteStart);
  }
}
