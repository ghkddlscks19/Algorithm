import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 학생 수
    int M = Integer.parseInt(st.nextToken()); // 키 비교 횟수

    List<List<Integer>> graph = new ArrayList<>();
    int degree[] = new int[N+1]; // 위상 정렬을 위한 indegree 수 저장

    for(int i =0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    
    // A가 B 앞에 서야한다.
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken()); 
      int B = Integer.parseInt(st.nextToken());

      // 방향 그래프
      graph.get(A).add(B);
      degree[B]++;
    }

    // 위상 정렬
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for(int i =1; i<=N; i++) {
      if(degree[i] == 0) q.offer(i);
    }

    while(!q.isEmpty()) {
      int curr = q.poll();
      bw.write(curr + " ");
      for(int next : graph.get(curr)) {
        degree[next]--;
        if(degree[next] == 0) q.offer(next);
      }
    }

    bw.flush();
    bw.close();
  }
}
