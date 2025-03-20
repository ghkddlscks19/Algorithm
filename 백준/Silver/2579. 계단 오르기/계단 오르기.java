import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int stair[] = new int[N+1];
    int dp[] = new int[N+1];

    for(int i =1; i<=N; i++) {
      stair[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = stair[1];
    if(N == 1) {
      bw.write(dp[1] + "");
      bw.flush();
      bw.close();
      return;
    }
    dp[2] = stair[1] + stair[2];
    if(N == 2) {
      bw.write(dp[2] + "");
      bw.flush();
      bw.close();
      return;      
    }
    dp[3] = Math.max(stair[1], stair[2]) + stair[3];
    if(N == 3) {
      bw.write(dp[3] + "");
      bw.flush();
      bw.close();
      return;      
    }
    
    for(int i =4; i<=N; i++) {
      dp[i] = Math.max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
    }

    bw.write(dp[N] + "");
    bw.flush();
    bw.close();

    
    
  }
}
