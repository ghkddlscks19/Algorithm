import java.util.*;
import java.io.*;
public class Main{
  static int N, M;
  static List<List<Integer>> graph = new ArrayList<>();
  static int cnt = 0;
  static boolean visited[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 정점의 개수
    M = Integer.parseInt(st.nextToken()); // 간선의 개수


    // 그래프 초기화
    for(int i = 0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      // 무방향 그래프
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    visited = new boolean[N+1];
    for(int i =1; i<=N; i++) {
      if(!visited[i]) {
        bfs(i);
        cnt++;        
      }
    }

    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
  }

  static void bfs(int v) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(v);
    visited[v] = true;
    
    while(!q.isEmpty()) {
      int curr = q.poll();

      for(int g : graph.get(curr)) {
        if(!visited[g]) {
          visited[g] = true;
          q.add(g);
        }
      }
    }   
  }
}
