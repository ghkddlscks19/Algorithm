import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    // 10000까지 소수 넣을 배열
    int arr[] = new int[10001];
    arr[1] = 1;
    for(int i =2; i<arr.length; i++) {
      for(int j = i*i; j<arr.length; j+=i) {
        arr[j] = 1; // 소수가 아닌 것은 1로 표시
      }
    }

    int sum = 0;
    int min = 10001;
    for(int i =N; i<=M; i++) {
      if(arr[i] == 0) { // 소수일 때
        sum += i;
        min = Math.min(i, min);
      }
    }

    // 소수가 없을 경우
    if(sum == 0 && min == 10001) bw.write(-1 + "");
    else {
      bw.write(sum + "\n");
      bw.write(min + "");
    }
   
    bw.flush();
    bw.close();
  }
}
