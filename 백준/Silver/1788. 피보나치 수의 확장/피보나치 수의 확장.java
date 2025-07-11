import java.util.*;
import java.io.*;
public class Main{
  public static final int MOD = 1000000000;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    if(n == 0) {
      bw.write("0" + "\n" + "0");
      bw.flush();
      bw.close();
      return;
    } else if(n > 0) {
      long result = fib(n); 
      bw.write("1" + "\n" + result + "");

    } else {
      long result = fib(-n); 
      if((-n) % 2 == 1) { // 음수면서 홀수면 양수
        bw.write("1" + "\n" + result + "");  
      } else {
        bw.write("-1" + "\n" + result + "");     
      }
    }   

    bw.flush();
    bw.close();
  }

  static long fib(int n) {
    if(n == 1 || n == 2) {
      return 1;
    } else {
      long fib[] = new long[n+1];
      fib[1] = fib[2] = 1;
      for(int i =3; i<=n; i++) {
        fib[i] = (fib[i-1] + fib[i-2]) % MOD;
      }
      return fib[n];
    }
  }   
}
