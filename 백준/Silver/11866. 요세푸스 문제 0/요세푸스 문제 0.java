import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for(int i =1; i<=N; i++) {
      queue.offer(i);
    }

    int cnt = 1;
    bw.write("<");
    while(queue.size() > 1) {
      int poll = queue.poll();
      if(cnt == K) {
        bw.write(poll + ", ");
        cnt = 1;
      } else {
        cnt++;
        queue.offer(poll);
      }
    }

    bw.write(queue.poll() + ">");

    bw.flush();
    bw.close();
  }
}
