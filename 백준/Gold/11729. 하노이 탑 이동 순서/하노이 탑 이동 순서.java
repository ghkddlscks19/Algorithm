import java.util.*;
import java.io.*;
public class Main{
  static StringBuilder sb = new StringBuilder();
  static int count = 0;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine()); 
    hanoi(N, 1, 2, 3);

    bw.write(count + "\n");
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  // N: 원판 갯수, start: 시작지, via: 경유지, end: 도착지
  static void hanoi(int N, int start, int via, int end) {
    if(N == 1) {
      sb.append(start + " " + end + "\n");
      count++;
      return;
    }

    // 1. N-1개의 원판을 시작지 -> 경유지
    hanoi(N-1, start, end, via);
    // 2. 가장 큰 원판을 시작지에서 목적지로 옮긴다
    sb.append(start + " " + end + "\n");
    count++;
    // 3. N-1개의 원판을 경유지 -> 도착지
    hanoi(N-1, via, start, end);
  }
}
