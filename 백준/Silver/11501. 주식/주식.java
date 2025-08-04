import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int t =0; t<T; t++) {
      int N = Integer.parseInt(br.readLine());
      int arr[] = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i =0; i<N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      long maxProfit = 0; // 최대 이익
      int maxPrice = 0; // 최대 가격

      for(int i =N-1; i>=0; i--) {
        if(arr[i] > maxPrice) maxPrice = arr[i];
        else maxProfit += maxPrice - arr[i];
      }

      bw.write(maxProfit + "\n");
    }

    bw.flush();
    bw.close();
  }
}
