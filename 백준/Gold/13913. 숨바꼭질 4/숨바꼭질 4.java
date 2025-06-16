import java.util.*;
import java.io.*;
public class Main{
  static int N, K;
  static int dist[];
  static int parent[]; // 어디서 왔는지 기록
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 수빈
    K = Integer.parseInt(st.nextToken()); // 동생

    dist = new int[100001];
    Arrays.fill(dist, INF);
    parent = new int[100001];
    Arrays.fill(parent, -1);

    int result = bfs(N);

    List<Integer> path = new ArrayList<>(); // 경로 저장 리스트
    int curr = K; // 역추적
    while(curr != -1) {
      path.add(curr);
      curr = parent[curr];
    }
    Collections.reverse(path);
  
    bw.write(String.valueOf(result));
    bw.newLine();

    for(int x : path) {
      bw.write(x + " ");
    }
    
    bw.flush();
    bw.close();
  }

  static int bfs(int n) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(n, 0));
    dist[n] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();
      
      if(curr.pos == K) return dist[K];

      // 순간이동
      int teleport = curr.pos * 2;
      if(teleport <= 100000 && dist[teleport] > curr.time + 1) {
        dist[teleport] = curr.time + 1;
        parent[teleport] = curr.pos;
        q.offer(new Point(teleport, curr.time + 1));
      }

      // 뒤로이동
      int back = curr.pos - 1;
      if(back >= 0 && dist[back] > curr.time + 1) {
        dist[back] = curr.time + 1;
        parent[back] = curr.pos;
        q.offer(new Point(back, curr.time + 1));
      }

      // 앞으로 이동
      int front = curr.pos + 1;
      if(front <= 100000 && dist[front] > curr.time + 1) {
        dist[front] = curr.time + 1;
        parent[front] = curr.pos;
        q.offer(new Point(front, curr.time + 1));
      }
      
    }

    return -1;
  }

  static class Point {
    int pos, time;

    public Point(int pos, int time) {
      this.pos = pos;
      this.time = time;
    }
  }
}
