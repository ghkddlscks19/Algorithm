import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int triangle[][] = new int[n][n];
    int dp[][] = new int[n][n];

    for(int i =0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<=i; j++) {
        triangle[i][j] = Integer.parseInt(st.nextToken()); // 입력 넣기
      }
    }

    dp[0][0] = triangle[0][0];

    for(int i =1; i<n; i++) {
      for(int j =0; j<=i; j++) {
        if(j == 0) { // 맨 왼쪽
          dp[i][j] = dp[i-1][j] + triangle[i][j];
        } else if(i == j) { // 맨 오른쪽
          dp[i][j] = dp[i-1][j-1] + triangle[i][j];
        } else { // 중간
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
        }
      }
    }

    int result = dp[n-1][0]; // 마지막 줄
    for(int i =1; i<n; i++) {
      result = Math.max(result, dp[n-1][i]);
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }
}
