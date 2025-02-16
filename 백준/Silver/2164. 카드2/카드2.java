import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for(int i =1; i<=N; i++) {
      queue.offer(i);
    }

    int i = 0;
    while(queue.size() > 1) {
      if(i % 2 == 0) queue.poll();
      else {
        int poll = queue.poll();
        queue.offer(poll);
      }
      i++;
    }

    bw.write(queue.poll() + " ");
    bw.flush();
    bw.close();
  }
}
