import java.util.*;
import java.io.*;
public class Main{
  static int N;
  static int t[], p[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    t = new int[N];
    p = new int[N];

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }

    int result = dfs(0, 0);

    bw.write(result + "");
    bw.flush();
    bw.close();
  }

  static int dfs(int index, int sum) {
    // 인덱스가 넘어가면 현재까지의 수익 반환
    if(index >= N) return sum;

    int max = 0;

    if(index + t[index] <= N) {
      // 현재 상담 선택
      max = Math.max(max, dfs(index + t[index], sum + p[index]));
    }

    // 현재 상담을 선택하지 않은 경우
    max = Math.max(max, dfs(index + 1, sum));

    return max;
    
  }
}
