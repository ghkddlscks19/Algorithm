import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int dp[] = new int[N+1];

    if(N == 1) {
      bw.write("1");
      bw.flush();
      bw.close();
      return;
    } else if(N == 2) {
      bw.write("2");
      bw.flush();
      bw.close();
      return;
    } else {
      dp[1] = 1;
      dp[2] = 2;
      
      for(int i =3; i<=N; i++) {
        dp[i] = (dp[i-2] + dp[i-1]) % 15746;
      }
  
      bw.write(String.valueOf(dp[N] % 15746));
      bw.flush();
      bw.close();
    }
  }
}
