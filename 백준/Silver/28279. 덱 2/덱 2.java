import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    ArrayDeque<Integer> deque = new ArrayDeque<>();

    for(int i =0; i<N; i++) {
      String input = br.readLine();
      
      StringTokenizer st = new StringTokenizer(input);
      int command = Integer.parseInt(st.nextToken());
      int X = 0;

      if (st.hasMoreTokens()) {
          X = Integer.parseInt(st.nextToken());
      }

      if(command == 1) {
        deque.addFirst(X);
      } else if(command == 2) {
        deque.addLast(X);
      } else if(command == 3) {
        if(deque.isEmpty()) bw.write(-1 + "\n");
        else bw.write(deque.pollFirst() + "\n");
      } else if(command == 4) {
        if(deque.isEmpty()) bw.write(-1 + "\n");
        else bw.write(deque.pollLast() + "\n");
      } else if(command == 5) {
        int count = deque.size();
        bw.write(count + "\n");
      } else if(command == 6) {
        if(deque.isEmpty()) bw.write(1 + "\n");
        else bw.write(0 + "\n");
      } else if(command == 7) {
        if(!deque.isEmpty()) bw.write(deque.getFirst() + "\n");
        else bw.write(-1 + "\n");
      } else {
        if(!deque.isEmpty()) bw.write(deque.getLast() + "\n");
        else bw.write(-1 + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}
