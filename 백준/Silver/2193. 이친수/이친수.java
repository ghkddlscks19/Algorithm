import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    long dp[] = new long[91];

    dp[1] = dp[2] = 1;
    for(int i =3; i<=90; i++) {
      dp[i] = dp[i-2] + dp[i-1];
    }

    bw.write(String.valueOf(dp[N]));
    bw.flush();
    bw.close();
  }
}
