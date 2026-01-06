import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    long answer = dfs(A, B, C);
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  static long dfs(int A, int B, int C) {
    // 지수가 1이 되면 종료
    if(B == 1) {
      return A % C;
    }
    
    long half = dfs(A, B/2, C);

    if(B % 2 == 0) {
      return half * half % C;
    } else {
      return (half * half % C) * A % C;
    }
  }
}
