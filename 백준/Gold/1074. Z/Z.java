import java.util.*;
import java.io.*;
public class Main{
  static int count = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int answer = findZ(N, r, c);
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  static int findZ(int N, int r, int c) {
    if(N == 0) {
      return 0;
    }

    // 각 사분면의 변 길이
    int half = 1 << (N-1);

    // 각 사분면의 칸 수
    int quarter = half * half;

    if(r < half && c < half) { // 1번
      return findZ(N-1, r, c);
    } else if(r < half && c >= half) { // 2번 
      return quarter + findZ(N-1, r, c - half);
    } else if(r >= half && c < half) { // 3번
      return 2 * quarter + findZ(N-1, r - half, c);
    } else { // 4번
      return 3 * quarter + findZ(N-1, r - half, c - half);
    }
  }
}
