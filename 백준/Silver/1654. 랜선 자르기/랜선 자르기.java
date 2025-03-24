import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int arr[] = new int[K];
    
    for(int i =0; i<K; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    long right = arr[K-1];
    long left = 1;
    while(left <= right) {
      long cnt = 0;
      long mid = (left + right) / 2;

      // mid로 전체 돌면서 잘라보고 개수 몇개인지 확인
      for(int i =0; i<K; i++) cnt += arr[i] / mid;

      // N보다 개수가 작으면 더 작게 잘라야됨
      if(cnt < N) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    bw.write(right + "");
    bw.flush();
    bw.close();
  }
}
