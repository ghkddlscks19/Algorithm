import java.util.*;
import java.io.*;
public class Main{
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine()); // 도시 개수
    int m = Integer.parseInt(br.readLine()); // 버스 개수

    List<List<Info>> graph = new ArrayList<>(); // 그래프
    for(int i =0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }
    
    for(int i =1; i<=m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken()); // 출발 도시
      int end = Integer.parseInt(st.nextToken()); // 도착 도시
      int weight = Integer.parseInt(st.nextToken()); // 가중치

      graph.get(start).add(new Info(end, weight));
    }

    int dist[] = new int[n+1];
    Arrays.fill(dist, INF);

    StringTokenizer st = new StringTokenizer(br.readLine());
    int startCity = Integer.parseInt(st.nextToken());
    int endCity = Integer.parseInt(st.nextToken());

    // 다익스트라 알고리즘
    PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
      return o1.weight - o2.weight; // 가중치 오름 차순
    });
    dist[startCity] = 0;
    pq.offer(new Info(startCity, dist[startCity]));

    int pre[] = new int[n+1];
    
    while(!pq.isEmpty()) {
      Info curr = pq.poll();

      if(curr.weight > dist[curr.start]) continue;

      for(Info next : graph.get(curr.start)) {
        int ns = next.start;
        int nw = next.weight;

        if(dist[ns] > dist[curr.start] + nw) {
          dist[ns] = dist[curr.start] + nw;
          pq.offer(new Info(ns, dist[ns]));
          pre[ns] = curr.start;
        }
      }
    }

    // 최소 비용
    bw.write(dist[endCity] + "\n");
    
    // 경로에 포함된 도시 개수
    List<Integer> path = new ArrayList<>();
    int curr = endCity;

    while(curr != 0) {
      path.add(curr);
      curr = pre[curr];
    }

    // 이전으로 역추적 한 것이기 때문에 역순 정렬
    Collections.reverse(path);
    bw.write(path.size() + "\n");
    
    // 최소 비용을 갖는 경로를 방문 순서대로 출력
    for(int p : path) {
      bw.write(p + " ");
    }

    bw.flush();
    bw.close();
  }

  static class Info {
    int start, weight;

    public Info(int start, int weight) {
      this.start = start;
      this.weight = weight;
    }
  }
}
