import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean isPrime[] = new boolean[1000001];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for(int i =2; i*i<=1000000; i++) {
      if(isPrime[i]) {
        for(int j =i*i; j<=1000000; j+=i) {
          isPrime[j] = false;
        } 
      }
    }
    
      
    int T = Integer.parseInt(br.readLine());

    for(int t =0; t<T; t++) {
      int N = Integer.parseInt(br.readLine());
      int cnt = 0;

      for(int i =2; i<=N/2; i++) {
        if(isPrime[i] && isPrime[N-i]) {
          cnt++;
        }
      }

      bw.write(cnt + "\n");
    }
    
    bw.flush();
    bw.close();
  }
}
