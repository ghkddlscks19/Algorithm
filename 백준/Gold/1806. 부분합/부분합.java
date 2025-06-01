import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int arr[] = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int right = 0;
    int sum = arr[0];
    int min = 100000001;
    for(int left =0; left<N; left++) {
      while(sum < S && right < N) {
        right++;
        if(right != N) sum += arr[right];
      }

      if(right == N) break;
      min = Math.min(min, right - left + 1);
      sum -= arr[left];
    }

    if(min == 100000001) {
      bw.write(String.valueOf(0));
    } else {
      bw.write(String.valueOf(min));    
    }
    bw.flush();
    bw.close();
  }
}
