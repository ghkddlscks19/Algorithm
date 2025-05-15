import java.util.*;
import java.io.*;
public class Main{
  static int N, S, count = 0;
  static int arr[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);

    if(S == 0) count--;

    bw.write(count + "");
    bw.flush();
    bw.close();
  }
  static void dfs(int index, int sum) {
    if(index == N) {
      if(sum == S) {
        count++;
      }
      return;
    }

    // 현재 인덱스 선택
    dfs(index+1, sum + arr[index]);

    // 현재 인덱스 선택 X
    dfs(index+1, sum);
  }
}
