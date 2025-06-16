import java.util.*;
import java.io.*;

public class Main {
  static int T, n, cnt;
  static int student[];
  static boolean visited[];
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    T = Integer.parseInt(br.readLine());
    for(int t = 0; t < T; t++) {
      n = Integer.parseInt(br.readLine());
      student = new int[n + 1];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 1; i <= n; i++) {
        student[i] = Integer.parseInt(st.nextToken());
      }
      
      visited = new boolean[n + 1];
      cnt = 0;
      
      for(int i = 1; i <= n; i++) {
        if(!visited[i]) {
          bfs(i);
        }
      }
      
      bw.write(String.valueOf(n - cnt));
      bw.newLine();
    }
    
    bw.flush();
    bw.close();
  }
  
  static void bfs(int start) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    HashMap<Integer, Integer> distance = new HashMap<>();  // 시작점으로부터의 거리
    List<Integer> path = new ArrayList<>();
    
    q.offer(start);
    distance.put(start, 0);
    int dist = 0;
    
    while(!q.isEmpty()) {
      int curr = q.poll();
      path.add(curr);
      
      // 이미 다른 컴포넌트에서 방문된 경우
      if(visited[curr]) {
        for(int node : path) {
          visited[node] = true;
        }
        break;
      }
      
      int next = student[curr];
      
      // 사이클 발견 (이미 현재 탐색에서 방문한 노드)
      if(distance.containsKey(next)) {
        int cycleSize = dist + 1 - distance.get(next);
        cnt += cycleSize;
        
        // 모든 경로 노드 방문 처리
        for(int node : path) {
          visited[node] = true;
        }
        break;
      }
      
      // 다른 컴포넌트에서 이미 방문된 노드에 도달
      if(visited[next]) {
        for(int node : path) {
          visited[node] = true;
        }
        break;
      }
      
      // 다음 노드 추가
      dist++;
      distance.put(next, dist);
      q.offer(next);
    }
  }
}