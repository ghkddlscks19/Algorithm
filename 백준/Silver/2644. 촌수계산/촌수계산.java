import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int p1 = Integer.parseInt(st.nextToken()); 
    int p2 = Integer.parseInt(st.nextToken()); 
    int m = Integer.parseInt(br.readLine());

    List<List<Integer>> graph = new ArrayList<>();
    // 그래프로 풀어야할듯. 양방향 연결관계. 최소거리
    for(int i =0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    // x, y 입력 후 양방향 연결
    for(int i =0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph.get(x).add(y);
      graph.get(y).add(x);  
    }

    // 방문 여부 확인
    boolean visited[] = new boolean[n+1];
    int dist[] = new int[n+1];
    // bfs 사용
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.offer(p1);
    visited[p1] = true;

    while(!q.isEmpty()) {
      int poll = q.poll();
      
      if(poll == p2) break;

      for(int next :graph.get(poll)) {
        if(!visited[next]) {
          visited[next] = true;
          dist[next] = dist[poll] + 1;
          q.offer(next);
        }
      }
    }

    if(dist[p2] == 0) bw.write("-1");
    else bw.write(dist[p2] + "");

    bw.flush();
    bw.close();
  }
}
