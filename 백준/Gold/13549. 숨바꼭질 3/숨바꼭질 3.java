import java.util.*;
import java.io.*;
public class Main{
  static int N, K;
  static int map[];
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[100001];
    Arrays.fill(map, INF);

    bfs(N);

    bw.write(String.valueOf(map[K]));
    bw.flush();
    bw.close();
  }

  static int bfs(int x) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(x, 0));
    map[x] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      // 짧은 경로가 있으면 패스
      if (curr.time > map[curr.pos]) {
        continue;
      }

      // 위치에 도달하면 리턴
      if(curr.pos == K) {
        return map[K];
      }

      // 순간이동
      int teleport = curr.pos * 2;
      if(teleport <= 100000 && map[teleport] > curr.time) {
        map[teleport] = curr.time;
        q.offer(new Point(teleport, curr.time));
      }

      // 뒤로이동
      int back = curr.pos - 1;
      if(back >= 0 && map[back] > curr.time + 1) {
        map[back] = curr.time + 1;
        q.offer(new Point(back, curr.time + 1));
      }

      // 앞으로이동
      int front = curr.pos + 1;
      if(front <= 100000 && map[front] > curr.time + 1) {
        map[front] = curr.time + 1;
        q.offer(new Point(front, curr.time + 1));
      }
    }

    return map[K];
  }

  static class Point {
    int pos, time;

    public Point(int pos, int time) {
      this.pos = pos;
      this.time = time;
    }
  }
}
