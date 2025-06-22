import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int arr[] = new int[N];

    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int len[] = new int[N];

    int max = 0;
    for(int i =0; i<N; i++) {
      len[i] = 1;
      for(int j =0; j<i; j++) {
        if(arr[i] > arr[j]) {  
          len[i] = Math.max(len[i], len[j] + 1);
        }
      }
      max = Math.max(len[i], max);
    }
    
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
  }
}
