import java.util.*;
import java.io.*;
public class Main{
  static int cnt = 0;
  static StringBuilder sb = new StringBuilder();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    hanoi(1, 2, 3, N);
    bw.write(cnt + "\n");
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static void hanoi(int start, int mid, int end, int n) {
    // n이 1이면 출력
    if(n == 1) {
      cnt++;
      sb.append(start + " " + end + "\n");
      return;
    }
    // 1. n-1개 start -> mid로 이동 
    hanoi(start, end, mid, n-1);
    // 2. 1개를 start -> end로 이동 후 출력
    hanoi(start, mid, end, 1);
    // 3. n-1개 mid -> end로 이동
    hanoi(mid, start, end, n-1);
  }
}
