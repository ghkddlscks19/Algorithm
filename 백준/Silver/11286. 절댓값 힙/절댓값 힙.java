import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      // 절댓값이 같은 경우에는 오름차순으로 정렬
      if(Math.abs(o1) == Math.abs(o2)) {
        return o1 - o2;
      }
      return Math.abs(o1) - Math.abs(o2);
    });
    for(int i =0; i<N; i++) {
      int x = Integer.parseInt(br.readLine());
      if(x != 0) {
        pq.offer(x);
      } else {
        if(pq.isEmpty()) bw.write("0"); // 비어 있는 경우에는 0 출력
        else bw.write(String.valueOf(pq.poll()));
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
  }
}
