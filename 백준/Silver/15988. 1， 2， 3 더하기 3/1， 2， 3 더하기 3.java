import java.util.*;
import java.io.*;
public class Main{
  public static final int MOD = 1000000009;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int tc =0; tc<T; tc++) {
      int n = Integer.parseInt(br.readLine());
      long dp[] = new long[n+1];
      if(n == 1) {
        bw.write(String.valueOf(1));
      } else if(n == 2) {
        bw.write(String.valueOf(2));
      } else if(n == 3) {
        bw.write(String.valueOf(4));
      } else {
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for(int i =4; i<=n; i++) {
          dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD;     
        }
        bw.write(String.valueOf(dp[n]));
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
