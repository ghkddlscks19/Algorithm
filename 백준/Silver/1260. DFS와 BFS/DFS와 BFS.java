import java.util.*;
import java.io.*;
public class Main{
  static int N, M, V;
  static boolean visited[];
  static List<List<Integer>> graph = new ArrayList<>(); 
  static StringBuilder sb;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      // 양방향 그래프
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }

    for(int i =0; i<=N; i++) {
      Collections.sort(graph.get(i));
    }

    visited = new boolean[N+1];
    sb = new StringBuilder();
    dfs(V);
    bw.write(sb.toString());
    bw.newLine();
    
    visited = new boolean[N+1];
    sb = new StringBuilder();
    bfs(V);
    bw.write(sb.toString());

    bw.flush();
    bw.close();
  }

  static void dfs(int v) {
    visited[v] = true;
    sb.append(v + " ");
    for(int next : graph.get(v)) {
      if(!visited[next]) {
        dfs(next);
      }
    }
  }
  static void bfs(int v) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(v);
    visited[v] = true;

    while(!q.isEmpty()) {
      int curr = q.poll();
      sb.append(curr + " ");

      for(int next : graph.get(curr)) {
        if(!visited[next]) {
          visited[next] = true;
          q.add(next);
        }
      }
    }
  }
}
