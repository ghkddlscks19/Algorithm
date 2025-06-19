import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int X = Integer.parseInt(br.readLine());

    int dp[] = new int[X+1];

    int parent[] = new int[X+1];
    for(int i =2; i<=X; i++) {
      dp[i] = dp[i-1] + 1;
      parent[i] = i-1;

      if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
        dp[i] = dp[i/2] + 1;
        parent[i] = i/2;
      }
      if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
        dp[i] = dp[i/3] + 1;
        parent[i] = i/3;
      }
    }

    bw.write(String.valueOf(dp[X]));
    bw.newLine();

    List<Integer> path = new ArrayList<>();
    int curr = X;
    while(curr != 0) {
      path.add(curr);
      curr = parent[curr];
    }

    for(int i =0; i<path.size(); i++) {
      bw.write(path.get(i) + " ");
    }

    bw.flush();
    bw.close();
  }
}
