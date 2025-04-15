import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int arr[] = new int[n];
    long sum = 0;
    for(int i =0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
    }

    long answer = 0;
    for(int i =0; i<n; i++) {  
      sum -= arr[i];
      answer += arr[i] * sum;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
    
  }
}
