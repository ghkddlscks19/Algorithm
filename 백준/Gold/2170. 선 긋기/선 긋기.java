import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // 우선순위 큐 x가 작은 순으로 반환
    PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.x - b.x);
    
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      pq.offer(new Point(x, y));
    }

    int start = -1000000001;
    int end = 1000000001;
    int result = 0;
    while(!pq.isEmpty()) {
      Point curr = pq.poll();
      int nx = curr.x;
      int ny = curr.y; 

      // 첫 번째 선분이거나 현재 선분이 이전 구간과 겹치지 않는 경우
      if(start == -1000000001 || nx > end) {
        // 이전 구간이 있으면 더하기
        if(start != -1000000001) result += end - start;

        // 새로운 구간 시작
        start = nx;
        end = ny;
      }
        
      else {
        end = Math.max(end, ny);
      }
    }

    // 마지막 선분 계산
    if(start != -1000000001) {
      result += end - start;
    }

    bw.write(result + "");
    bw.flush();
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
