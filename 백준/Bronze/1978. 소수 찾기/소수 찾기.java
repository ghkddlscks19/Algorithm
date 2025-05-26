import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int cnt = 0;
    for(int i =0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if(isPrime(num)) cnt++;
    }

    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
    
  }

  static boolean isPrime(int n) {
    if(n == 1) return false;
    for(int i = 2; i*i<=n; i++) {
      if(n % i == 0) return false;
    }
    return true;
  }
}
