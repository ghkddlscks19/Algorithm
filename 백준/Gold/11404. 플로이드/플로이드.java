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

    // 초기에 큰값으로 초기화 / 자기 자신은 0
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

      map[a][b] = Math.min(map[a][b], c); // 중복 경로가 있을 수 있으므로 비용이 적은 것만 넣기
    }

    for(int k =1; k<=n; k++) {
      for(int i =1; i<=n; i++) {
        for(int j =1; j<=n; j++) {
          if(map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }

    for(int i =1; i<=n; i++) {
      for(int j =1; j<=n; j++) {
        if(map[i][j] == INF) bw.write(0 + " ");
        else bw.write(map[i][j] + " ");
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
