import java.util.*;
import java.io.*;
public class Main{
  static List<List<Integer>> tree = new ArrayList<>();
  static int parent[];
  static boolean visited[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for(int i =0; i<=N; i++) {
      tree.add(new ArrayList<>());
    }

    for(int i =0; i<N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      // 트리는 양방향 연결
      tree.get(n1).add(n2);
      tree.get(n2).add(n1);
    }

    parent = new int[N+1];
    visited = new boolean[N+1];

    bfs(1);

    for(int i =2; i<=N; i++) {
      bw.write(String.valueOf(parent[i]));
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static void bfs(int n) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(n);
    visited[n] = true;

    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int next : tree.get(curr)) {
        if(!visited[next]) {
          visited[next] = true;
          parent[next] = curr;
          q.offer(next);
        }
      }
    }
  }
}
