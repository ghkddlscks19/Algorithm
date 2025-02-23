import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int answer = 0;

    while(N >= 5) {
      answer += N / 5;
      N /= 5;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();

  }


}
