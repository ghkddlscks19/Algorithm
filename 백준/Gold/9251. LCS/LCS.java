import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] c1 = br.readLine().toCharArray();
    char[] c2 = br.readLine().toCharArray();

    int[][] dp = new int[c1.length + 1][c2.length + 1];

    for(int i =1; i<=c1.length; i++) {
      for(int j =1; j<=c2.length; j++) {
        
        if(c1[i-1] == c2[j-1]) {
          dp[i][j] = dp[i-1][j-1] + 1; 
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    bw.write(dp[c1.length][c2.length] + "");
    bw.flush();
    bw.close();
  }
}
