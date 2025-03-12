import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 정수 입력 받기
    int X = Integer.parseInt(br.readLine());

    int dp[] = new int[1000001];

    dp[0] = dp[1] = 0;
    
    for(int i =2; i<=X; i++) {
      dp[i] = dp[i-1] + 1;
      if(i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i/3] + 1);
      }
      if(i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i/2] + 1);   
      }
    }

    bw.write(dp[X] + "");
    bw.flush();
    bw.close();
  }
}
