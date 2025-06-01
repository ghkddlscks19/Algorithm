import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int arr[] = new int[N];
    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 정렬
    Arrays.sort(arr);

    // 투포인터 풀이
    int right = 0;
    int min = Integer.MAX_VALUE;
    for(int left =0; left<N; left++) {
      while(right < N && arr[right] - arr[left] < M) right++;
      if(right == N) break; // right가 끝까지 가면 종료
      min = Math.min(min, arr[right] - arr[left]);
    }

    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
  }
}
