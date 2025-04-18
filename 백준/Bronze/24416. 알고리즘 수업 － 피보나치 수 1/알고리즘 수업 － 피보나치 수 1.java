import java.util.*;
import java.io.*;

public class Main{
  static int f[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    f = new int[n+1];
    f[1] = f[2] = 1;
    
    int f1 = fib(n);
    int f2 = fibonacci(n) - 2;
    
    bw.write(f1 + " " + f2);
    bw.flush();
    bw.close();
  }

  static int fib(int n) {    
    if(n <= 2) return 1;
    else return fib(n-1) + fib(n-2);
  }

  static int fibonacci(int n) {
    for(int i =3; i<=n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return n;
  }
}
