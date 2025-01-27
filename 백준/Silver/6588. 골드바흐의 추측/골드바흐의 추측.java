import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    // 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다
    // n보다 작은 소수 중 가장 작은 소수와 가장 큰 소수를 뽑아낸다

    int arr[] = new int[1000001];
    arr[1] = 1;

    for(int i =2; i<Math.sqrt(arr.length); i++) {
      for(int j =i*i; j<arr.length; j+=i) {
        arr[j] = 1;
      }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      int n = Integer.parseInt(br.readLine());
      if(n == 0) break;
      boolean isValid = false;

      for(int i =2; i<=n/2; i++) {
        if(arr[i] == 0 && arr[n-i] == 0) {
          bw.write(n + " = " + i + " + " + (n-i) + "\n");
          isValid = true;
          break;
        }
      }
      if(!isValid) bw.write("Goldbach's conjecture is wrong.");

    }
    bw.flush();
    bw.close();
  }
}


