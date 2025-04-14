import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int map[][] = new int[M][N];

    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int dx[] = {0, 1};
    int dy[] = {1, 0};

    ArrayDeque<Point> q = new ArrayDeque<>();
    q.offer(new Point(0, 0));
    boolean visited[][] = new boolean[M][N];
    visited[0][0] = true;

    boolean end = false;
    // bfs로 구현
    while(!q.isEmpty()) {
      Point poll = q.poll();
      
      if(poll.x == M-1 && poll.y == N-1) {
        end = true;
        break;
      }
      
      for(int i =0; i<2; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];

        if(nx >= 0 && nx < M 
           && ny >=0 && ny < N 
           && !visited[nx][ny] && map[nx][ny] == 1) {
          visited[nx][ny] = true;
          q.offer(new Point(nx, ny)); 
           }
      }
    }

    if(end) bw.write("Yes");
    else bw.write("No");

    bw.flush();
    bw.close();
    
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
