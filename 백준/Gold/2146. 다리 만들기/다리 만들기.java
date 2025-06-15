import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int map[][];
  static boolean visited[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine()); // 크기

    map = new int[N][N]; // 지도
    visited = new boolean[N][N]; // 방문 여부

    // 지도 넣기
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 섬 별로 번호 매기기
    int num = 2;
    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(map[i][j] == 1 && !visited[i][j]) {
          numIsland(i, j, num++); 
        }
      }
    } 

    int result = Integer.MAX_VALUE;
    for (int i = 2; i < num; i++) {
      result = Math.min(result, findMinBridge(i));
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

  // 번호 매기기
  static void numIsland(int x, int y, int num) {
    visited[x][y] = true;
    map[x][y] = num;

    for(int i =0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

      if(map[nx][ny] == 0 || visited[nx][ny]) continue;

      numIsland(nx, ny, num);
    }
  }

  // 경계 구하기
  static boolean isBorder(int x, int y) {
    for(int i =0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
        if(map[nx][ny] == 0) return true;
      }
    }

    return false;
  }

  static int findMinBridge(int startIsland) {
    ArrayDeque<Point> q = new ArrayDeque<>();
    boolean bridgeVisited[][] = new boolean[N][N];

    // 경계 점들 큐에 넣기
    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(map[i][j] == startIsland && isBorder(i, j)) {
          q.offer(new Point(i, j, 0));
          bridgeVisited[i][j] = true;
        }
      }
    }

    // BFS로 최단 거리 찾기
    while(!q.isEmpty()) {
      Point curr = q.poll();

      for(int i =0; i<4; i++) {
        int nx = curr.x + dx[i];
        int ny = curr.y + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

        if(bridgeVisited[nx][ny]) continue;

        if(map[nx][ny] == 0) { // 바다인 경우
          bridgeVisited[nx][ny] = true;
          q.offer(new Point(nx, ny, curr.dist + 1));         
        } else if(map[nx][ny] != startIsland) { // 다른 섬과 만난 경우
          return curr.dist;          
        }
      }
    }

    return Integer.MAX_VALUE; // 도달하지 못한 경우
  }

  static class Point {
    int x, y, dist;

    public Point(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }
}