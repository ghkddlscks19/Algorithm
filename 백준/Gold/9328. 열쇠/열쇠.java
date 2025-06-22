import java.util.*;
import java.io.*;
public class Main{
  static int h, w;
  static char map[][];
  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static HashSet<Character> keys;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int t =0; t<T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      map = new char[h][w];
      keys = new HashSet<>(); // 키 넣어놓을 해시셋 (중복 X)

      // 지도 초기화
      for(int i =0; i<h; i++) {
        String line = br.readLine();
        for(int j =0; j<w; j++) {
          map[i][j] = line.charAt(j);
        }
      }

      // 초기 열쇠
      String initialKeys = br.readLine();
      if(!initialKeys.equals("0")) {
        for(char c : initialKeys.toCharArray()) {
          keys.add(c);
        }
      }

      int result = bfs();
      bw.write(String.valueOf(result));
      bw.newLine();
      
    }
    bw.flush();
    bw.close();
  }

  static int bfs() {
    int document = 0;

    while(true) {
      boolean found = false; // 새로운 걸 찾았는지 확인
      boolean visited[][] = new boolean[h][w];
      ArrayDeque<Point> q = new ArrayDeque<>();
      
      int startDocument = addStartPoints(q, visited);
      if(startDocument > 0) {
        document += startDocument;
        found = true;
      }

      while(!q.isEmpty()) {
        Point curr = q.poll();
  
        for(int i =0; i<4; i++) {
          int nx = curr.x + dx[i];
          int ny = curr.y + dy[i];
  
          if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
          if(visited[nx][ny]) continue;
          if(map[nx][ny] == '*') continue;
  
          char ch = map[nx][ny];

          // 문인 경우
          if(ch >= 'A' && ch <= 'Z') {
            char key = (char) (ch - 'A' + 'a');
            if(!keys.contains(key)) continue;
          }

          visited[nx][ny] = true;
          q.offer(new Point(nx, ny));

          // 열쇠인 경우
          if(ch >= 'a' && ch <= 'z') {
            if(!keys.contains(ch)) { // 열쇠 없으면 찾았다!
              keys.add(ch);
              found = true;
            }
          }

          // 문서인 경우
          if(ch == '$') {
            document++;
            found = true;
            map[nx][ny] = '.';
          }
        }
      }
      if(!found) break;
    }
    return document;
  }

  static int addStartPoints(ArrayDeque<Point> q, boolean visited[][]) {
    // 시작점에서 찾을 수 있는 문서 수
    int startDocument = 0;
    // 가장 자리에서 갈 수 있는 곳 확인
    for(int i =0; i<h; i++) {
      for(int j =0; j<w; j++) {
        // 가장 자리 아니면 스킵
        if(i != 0 && i != h-1 && j != 0 && j != w-1) continue;
        if(map[i][j] == '*') continue; // 벽 스킵
        if(visited[i][j]) continue; // 이미 방문 시 스킵

        char curr = map[i][j];

        // 현 위치가 문이면 열쇠 확인
        if(curr >= 'A' && curr <= 'Z') {
          char key = (char) (curr - 'A' + 'a');
          if(!keys.contains(key)) continue;
        }

        visited[i][j] = true;
        q.offer(new Point(i, j));

        // 시작점에서 열쇠나 문서일 경우
        if(curr >= 'a' && curr <= 'z') {
          keys.add(curr);
        }

        if(curr == '$') {
          map[i][j] = '.'; // 문서 획득
          startDocument++;
        }
      }
    }
    return startDocument;
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
