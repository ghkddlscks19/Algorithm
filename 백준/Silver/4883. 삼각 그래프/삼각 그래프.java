import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    int tc = 1;

    while((N = Integer.parseInt(br.readLine())) != 0) {
      int arr[][] = new int[N][3];
      for(int i =0; i<N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j =0; j<3; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int dp[][] = new int[N][3];
      dp[0][0] = Integer.MAX_VALUE;
      dp[0][1] = arr[0][1];
      dp[0][2] = dp[0][1] + arr[0][2];

  
      for(int i =1; i<N; i++) {
        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];
        dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), Math.min(dp[i-1][2], dp[i][0])) + arr[i][1];
        dp[i][2] = Math.min(dp[i-1][1], Math.min(dp[i][1], dp[i-1][2])) + arr[i][2];
      }
      bw.write(tc + ". " + dp[N-1][1] + "\n");
      tc++;
    } 

    bw.flush();
    bw.close();
  }
}
