import java.util.*;
import java.io.*;
public class Main{
  public static final int INF = 987654321;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine()); // 도시의 개수
    int m = Integer.parseInt(br.readLine()); // 버스의 개수

    int map[][] = new int[n+1][n+1];
    int next[][] = new int[n+1][n+1]; // 다음에 방문할 정점
    

    for(int i =1; i<=n; i++) {
      for(int j =1; j<=n; j++) {
        if(i == j) map[i][j] = 0;
        else map[i][j] = INF;
      }
    }

    for(int i =1; i<=m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()); // 시작 도시
      int b = Integer.parseInt(st.nextToken()); // 도착 도시
      int c = Integer.parseInt(st.nextToken()); // 비용

      if(map[a][b] > c) { // 중복 경로에서 최소 비용으로 넣어주기
        map[a][b] = c;
        next[a][b] = b; // a -> b 바로 갈 때 다음 정점은 b
      } 
    }

    
    // 최단거리 (플로이드 알고리즘)
    for(int k = 1; k<=n; k++) { // 경유
      for(int i =1; i<=n; i++) { // 시작
        for(int j =1; j<=n; j++) { // 도착
          if(map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
            next[i][j] = next[i][k]; // 최단 거리 경유지 저장
          }
        }
      }
    }

    // 최단 거리 출력
    for(int i =1; i<=n; i++) {
      for(int j =1; j<=n; j++) {
        if(map[i][j] == INF) bw.write("0 ");
        else bw.write(map[i][j] + " ");
      }
      bw.newLine();
    }

    // 경로 출력
    for(int i =1; i<=n; i++) {
      for(int j =1; j<=n; j++) {
        if(i == j || map[i][j] == INF) bw.write("0");
        else {
          List<Integer> path = new ArrayList<>(); // 경로 저장
          if(next[i][j] != 0) {
            int curr = i; // 현재 위치
            path.add(curr);
            while(curr != j) {
              curr = next[curr][j];
              path.add(curr);
            }
          }
          bw.write(path.size() + " ");
          for(int p : path) {
            bw.write(p + " ");
          }
        }

        bw.newLine();
      }   
    }

    bw.flush();
    bw.close();
  }
}
