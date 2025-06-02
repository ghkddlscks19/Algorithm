import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i =0; i<N; i++) {
      int num = Integer.parseInt(br.readLine());
      pq.offer(num);
    }

    int sum = 0;
    while(pq.size() >= 2) {
      sum = pq.poll() + pq.poll();
      answer += sum;
      pq.offer(sum);
    }
    
    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }
}
