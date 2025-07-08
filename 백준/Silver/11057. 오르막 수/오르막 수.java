import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int dp[][] = new int[N+1][10];

    // 1자리 일 때는 경우의 수 전부 1개
    for(int i =0; i<=9; i++) {
      dp[1][i] = 1;
    }

    for(int i =2; i<=N; i++) {
      for(int j =0; j<=9; j++) {
        for(int k =0; k<=j; k++) {
          dp[i][j] += dp[i-1][k];
          dp[i][j] %= 10007;
        }
      }
    }

    int sum = 0; // 합 저장 변수
    for(int i =0; i<=9; i++) {
      sum += dp[N][i];
      sum %= 10007;
    }

    bw.write(String.valueOf(sum));
    bw.flush();
    bw.close();
  }
}
