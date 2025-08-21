import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
    int N = Integer.parseInt(br.readLine());

    // 강의 시간 담을 리스트
    List<Subject> lectureList = new ArrayList<>();
    
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      lectureList.add(new Subject(start, end));
    }

    // 시작 시간 순 정렬
    Collections.sort(lectureList, (a, b) -> {
      return a.start - b.start;
    });

    // 우선순위 큐 사용
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(Subject lecture: lectureList) {
      int start = lecture.start;
      int end = lecture.end;

      // 큐가 비어있는지 확인
      if(!pq.isEmpty() && pq.peek() <= start) {
        pq.poll();
      }

      pq.offer(end);
    }

    bw.write(pq.size() + "");
    bw.flush();
    bw.close();
    
  }
  static class Subject {
    int start, end;

    public Subject(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
