import java.util.*;
import java.io.*;
public class Main{
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken()); // 정점의 개수
    int E = Integer.parseInt(st.nextToken()); // 간선의 개수

    // 그래프 넣을 공간 만들기
    List<List<Info>> graph = new ArrayList<>();
    for(int i =0; i<=V; i++) {
      graph.add(new ArrayList<>());
    }

    
    int K = Integer.parseInt(br.readLine()); // 시작 정점
    
    int dist[] = new int[V+1]; // 최단 거리 저장
    Arrays.fill(dist, INF);
    for(int i =1; i<=E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // 시작 정점
      int v = Integer.parseInt(st.nextToken()); // 도착 정점
      int w = Integer.parseInt(st.nextToken()); // 가중치

      graph.get(u).add(new Info(v, w));
    }

    PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
      return o1.w - o2.w;
    });
    
    dist[K] = 0;
    pq.offer(new Info(K, dist[K]));

    while(!pq.isEmpty()) {
      Info curr = pq.poll();

      if(curr.w > dist[curr.v]) continue;

      for(Info next: graph.get(curr.v)) {
        int nv = next.v;
        int nw = next.w;

        if(dist[nv] > dist[curr.v] + nw) {
          dist[nv] = dist[curr.v] + nw;
          pq.offer(new Info(nv, dist[nv]));
        }
      }
    }
   for(int i =1; i<=V; i++) {
      if(dist[i] == INF) bw.write("INF");
      else bw.write(String.valueOf(dist[i]));
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static class Info {
    int v, w;

    public Info(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
}
