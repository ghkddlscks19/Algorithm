import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for(int i =2; i*i<=N; i++) {
      while(N % i == 0) {
        bw.write(String.valueOf(i));
        bw.newLine();
        N /= i;
      }
    }

    if(N != 1) {
      bw.write(String.valueOf(N));
      bw.newLine();
    }
    
    bw.flush();
    bw.close();
  }
}
