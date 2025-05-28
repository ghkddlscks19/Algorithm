import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int result = solve(M, N, x, y);
      bw.write(String.valueOf(result));
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static int solve(int M, int N, int x, int y) {
      int l = lcm(M, N);

      for(int i =x; i<=l; i+=M) {
        int second = ((i -1) % N) + 1;

        if(second == y) {
          return i;
        }
      }

      return -1;
    }
  
  static int gcd(int a, int b) {
    if(b == 0) return a;

    return gcd(b, a % b);
  }

  static int lcm(int a, int b) {
    return a / gcd(a,b) * b;
  }

    
}
