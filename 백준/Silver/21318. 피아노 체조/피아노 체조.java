import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N+1]; // 1~N
    int sum[] = new int[N+1]; // 실패를 누적한다

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 입력 받기
    for(int i =1; i<=N; i++) {   
      arr[i] = Integer.parseInt(st.nextToken());

      if(arr[i] < arr[i-1]) sum[i] = sum[i-1] + 1;
      else sum[i] = sum[i-1];
    }

    int Q = Integer.parseInt(br.readLine());
    int result = 0;
    for(int i =0; i<Q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      result = sum[y] - sum[x];
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
  }
}
