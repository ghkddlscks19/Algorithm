import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int dp[][] = new int[N+1][K+1];

    for(int i =0; i<=N; i++) {
      dp[i][0] = 1;
    }

    for(int i =1; i<=N; i++) {
      for(int j =1; j<=Math.min(i,K); j++) {
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
      }
    }

    bw.write(dp[N][K] + "");
    bw.flush();
    bw.close();
    
  }
}
