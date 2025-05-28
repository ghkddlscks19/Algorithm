import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int comb[][] = new int[1001][1001];
    int mod = 10007;

    for(int i =1; i<=1000; i++) {
      comb[i][0] = comb[i][i] = 1;
      for(int j =1; j<i; j++) {
        comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % mod;
      }
    }

    bw.write(String.valueOf(comb[N][K]));
    bw.flush();
    bw.close();
  }
}
