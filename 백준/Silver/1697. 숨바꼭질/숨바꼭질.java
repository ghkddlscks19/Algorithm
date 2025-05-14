import java.util.*;
import java.io.*;
public class Main{
  static int N, K;
  static int dist[];
  static int move[] = {-1, 1, 2};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    dist = new int[1000001];
    Arrays.fill(dist, Integer.MAX_VALUE); // 거리 일단 최대값으로! 최소 시간 구하는거니까!

    int answer = bfs(N);
    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  static int bfs(int x) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.offer(x);
    dist[x] = 0;

    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int i =0; i<3; i++) {
        int next = 0;
        if(i < 2) next = curr + move[i];
        else next = curr * move[i];

        if(next >= 0 && next <= 100000 && dist[next] == Integer.MAX_VALUE) {
          q.offer(next);
          dist[next] = dist[curr] + 1;
        }
      }
    }
    return dist[K];
  }
}
