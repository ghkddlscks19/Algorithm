import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int tc =0; tc<T; tc++) {
      int n = Integer.parseInt(br.readLine());
      int sticker[][] = new int[2][n];
      for(int i =0; i<2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j =0; j<n; j++) {
          sticker[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int dp[] = new int[3];
      dp[0] = sticker[0][0];
      dp[1] = sticker[1][0];
      dp[2] = 0;
      
      for(int i =1; i<n; i++) {
        int newDp0 = sticker[0][i] + Math.max(dp[1], dp[2]);
        int newDp1 = sticker[1][i] + Math.max(dp[0], dp[2]);
        int newDp2 = Math.max(dp[0], Math.max(dp[1], dp[2]));

        dp[0] = newDp0;
        dp[1] = newDp1;
        dp[2] = newDp2;
      }
      int result = Math.max(dp[0], Math.max(dp[1], dp[2]));
      bw.write(String.valueOf(result));
      bw.newLine();
    }
      bw.flush();
      bw.close();
  }
}
