import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int R[] = new int[N+1];
    int G[] = new int[N+1];
    int B[] = new int[N+1];

    for(int i =1; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      R[i] = Integer.parseInt(st.nextToken());
      G[i] = Integer.parseInt(st.nextToken());
      B[i] = Integer.parseInt(st.nextToken());
    }

    // 0: 빨강, 1: 초록, 2: 파랑
    int dp[][] = new int[N+1][3];
    dp[1][0] = R[1];
    dp[1][1] = G[1];    
    dp[1][2] = B[1];

    for(int i =2; i<=N; i++) {
      dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
      dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
      dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i];
    }

    int answer = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
