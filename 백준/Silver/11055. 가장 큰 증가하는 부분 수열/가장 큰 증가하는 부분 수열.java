import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int num[] = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    int dp[] = new int[N];

    for(int i =0; i<N; i++) {
      dp[i] = num[i];
      for(int j =0; j<i; j++) {
        if(num[i] > num[j]) {
          dp[i] = Math.max(dp[i], dp[j] + num[i]);
        }
      }
    }

    int max = 0;
    for(int x : dp) {
      max = Math.max(max, x);
    }

    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
  }
}
