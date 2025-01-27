import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    
    int arr[] = new int[1000001];
    arr[1] = 1;
    
    for(int i =2; i<Math.sqrt(arr.length); i++) {
      for(int j =i*i; j<arr.length; j+=i) {
        arr[j] = 1;
      }
    }
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    for(int i =M; i<=N; i++) {
      if(arr[i] == 0) {
        bw.write(i + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}


