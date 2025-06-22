import java.util.*;
import java.io.*;

public class Main{
  static int N, K;
  static boolean visited[][];
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    
    // 초기 조건 처리
    if(N == K) {
      bw.write("0");
      bw.flush();
      bw.close();
      return;
    }
    
    int result = bfs();
    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

  static int bfs() {
    visited = new boolean[500001][2];
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(N, 0));
    visited[N][0] = true;

    int time = 0;
    while (true) {
      int brotherPos = K + time * (time + 1) / 2;
      if (brotherPos > 500000) return -1;
  
      if (visited[brotherPos][time % 2]) return time;
  
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Point curr = q.poll();
        int pos = curr.pos;

        int nextPos[] = {pos - 1, pos + 1, pos * 2};
        for (int next : nextPos) {
          if (next < 0 || next > 500000) continue;
          
          if (!visited[next][(time + 1) % 2]) {
            visited[next][(time + 1) % 2] = true;
            q.offer(new Point(next, time + 1));
          }
        }
      }
  
      time++;
    }
  }


  static class Point {
    int pos, time;

    public Point(int pos, int time) {
      this.pos = pos;
      this.time = time;
    }
  }
}