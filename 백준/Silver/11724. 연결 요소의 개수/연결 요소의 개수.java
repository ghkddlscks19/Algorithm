import java.util.*;
import java.io.*;

public class Main{
  static boolean visited[];
  static List<List<Integer>> graph;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();

    for(int i =0; i<N+1; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }


    visited = new boolean[N+1];  
    int count = 0;
    
    for(int i =1; i<N+1; i++) {
      if(!visited[i]) {
        dfs(i);
        count++;
      }
    }

    bw.write(count + "");
    bw.flush();
    bw.close();
  }

  static void dfs(int node) {
    visited[node] = true;

    for(int next : graph.get(node)) {
      if(!visited[next]) {
        dfs(next);   
      }
    }
  }
}
