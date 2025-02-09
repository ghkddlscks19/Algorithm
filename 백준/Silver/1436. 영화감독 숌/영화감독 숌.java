import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int cnt = 0;
    int answer = 0;

    for(int i =0; i<=10000000; i++) {
      if(String.valueOf(i).contains("666")) {
        cnt++;
        if(cnt == N) {
          answer = i;
          break;
        }
      }
    }
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
