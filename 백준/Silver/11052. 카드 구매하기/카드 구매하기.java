import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int p[] = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =1; i<=N; i++) {
      p[i] = Integer.parseInt(st.nextToken());
    }

    int dp[] = new int[N+1];

    for(int i =1; i<=N; i++) {
      for(int j =1; j<=i; j++) {
        dp[i] = Math.max(dp[i], dp[Math.abs(i-j)] + p[j]);
      }
    }

    bw.write(String.valueOf(dp[N]));
    bw.flush();
    bw.close();
  }
}
