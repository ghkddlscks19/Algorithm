import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 10^3 * 10^6 = 10^9 > 10^8 -> n^2 불가 nlogn 써야될듯
    long arr[] = new long[1000001];
    Arrays.fill(arr, 1);

    // 약수를 다 더한 값을 배열에 초기화
    for(int i =2; i<1000001; i++) {
      for(int j =i; j<1000001; j+=i) {
        arr[j] += i;
      }
    }

    // 전의 값들을 더해주는 반복문
    for(int i =2; i<1000001; i++) {
      arr[i] += arr[i-1];
    }

    int T = Integer.parseInt(br.readLine());
    for(int i =0; i<T; i++) {
      int N = Integer.parseInt(br.readLine());
      bw.write(arr[N] + "\n");
    }
    
    bw.flush();
    bw.close();
  }
}
