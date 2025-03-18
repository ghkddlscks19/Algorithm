import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 배열 선언 및 입력 받기
    int arr[] = new int[N+1];
    int dp[] = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i =1; i<arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      // 구간 합 저장
      dp[i] = dp[i-1] + arr[i];
    }

    // 구간 입력 받기
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      bw.write(dp[end] - dp[start - 1] + "");
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
