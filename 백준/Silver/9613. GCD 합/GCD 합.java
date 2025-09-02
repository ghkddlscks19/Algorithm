import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int t =0; t<T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int arr[] = new int[n];
      
      for(int i =0; i<n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      // 반복문 돌면서 gcd 합 구하기
      long sum = 0;
      for(int i =0; i<n; i++) {
        for(int j =i+1; j<n; j++) {
          sum += (long) gcd(arr[i], arr[j]);
        }
      }

      bw.write(sum + "\n");
    }

    bw.flush();
    bw.close();
  }

  static int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a % b);
  }
}
