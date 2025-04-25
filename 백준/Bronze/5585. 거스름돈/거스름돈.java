import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    N = 1000 - N;
    int cnt = 0;
    int coins[] = {500, 100, 50, 10, 5, 1};

    for(int coin: coins) {
      cnt += N / coin;
      N %= coin;
    }
    
    bw.write(cnt + "");
    bw.flush();
    bw.close();
  }
}
