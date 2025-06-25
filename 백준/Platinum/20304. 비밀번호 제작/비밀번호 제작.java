import java.util.*;
import java.io.*;
public class Main{
  static ArrayDeque<Integer> q = new ArrayDeque<>();
  static int N, M, max;
  static boolean visited[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine()); // 최댓값 <= 1000000
    M = Integer.parseInt(br.readLine()); // 개수 <= 100000

    StringTokenizer st = new StringTokenizer(br.readLine());

    visited = new boolean[N+1];
    for(int i =0; i<M; i++) {
      int password = Integer.parseInt(st.nextToken());
      q.offer(password);
      visited[password] = true;
    }

    if(M == 0) {
      max = Integer.toBinaryString(N).length();
    } else {
      bfs();
    }
    
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
  }

  static void bfs() {
    while(!q.isEmpty()) {
      int size = q.size();
      boolean hasNext = false;

      for(int i =0; i<size; i++) {
        int curr = q.poll();

        for(int bit =0; bit<=20; bit++) {
          int next = curr ^ (1 << bit);

          if(next <= N && !visited[next]) {
            visited[next] = true;
            q.offer(next);
            hasNext = true;
          }
        }
      }

      if(hasNext) max++;
    }
  }
}
