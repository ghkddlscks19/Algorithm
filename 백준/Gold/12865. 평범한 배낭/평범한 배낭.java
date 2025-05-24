import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int weight[] = new int[N+1];
    int value[] = new int[N+1];

    for(int i =1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      weight[i] = Integer.parseInt(st.nextToken());
      value[i] = Integer.parseInt(st.nextToken());
    }

    // i번째 물건까지 고려했을 때 무게 w 이하로 가질 수 있는 최대 가치
    int[][] dp = new int[N+1][K+1]; 
    for(int i =1; i<=N; i++) {
      for(int w =1; w<=K; w++) {
        if(weight[i] <= w) {
          dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i]);
        } else {
          dp[i][w] = dp[i-1][w];
        }
      }
    }

    bw.write(dp[N][K] + "");
    bw.flush();
    bw.close();
  }
}
