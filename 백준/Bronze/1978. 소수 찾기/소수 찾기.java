import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 1000까지 소수인 수 체크
    int arr[] = new int[1001];
    arr[1] = 1;

    for(int i = 2; i<arr.length; i++) {
      for(int j = i*i; j<arr.length; j+=i) {
        arr[j] = 1;
      }
    }
    
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;

    for(int i =0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if(arr[num] == 0) answer++;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();

  }
}


