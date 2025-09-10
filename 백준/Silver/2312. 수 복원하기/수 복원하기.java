import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int i =0; i<T; i++) {
      int N =Integer.parseInt(br.readLine());
      recovery(N, bw);
    }

    bw.flush();
    bw.close();
  }

  static void recovery(int n, BufferedWriter bw) throws IOException {
    for(int i =2; i*i<=n; i++) {
      int count = 0;
      while(n % i == 0) {
        n /= i;
        count++;
      }

      if(count > 0) {
        bw.write(i + " " + count + "\n");
      }
    }

    if(n > 1) {
      bw.write(n + " 1" + "\n");
    }
  }
}
