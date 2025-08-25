import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Calender[] flowers = new Calender[N];

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int sm = Integer.parseInt(st.nextToken());
      int sd = Integer.parseInt(st.nextToken());
      int em = Integer.parseInt(st.nextToken());
      int ed = Integer.parseInt(st.nextToken());
      flowers[i] = new Calender(sm, sd, em, ed);
    }

    Arrays.sort(flowers, (a, b) -> a.start - b.start);

    // 종료일 역순 정렬
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    int curr = 301; // 3월1일부터 시작
    int index = 0;
    int count = 0;

    while(curr <= 1130) { // 11월30일 까지
      // curr 이전에 시작하는 꽃들 다 넣기
      while(index < N && flowers[index].start <= curr) {
        pq.offer(flowers[index].end);
        index++;
      }

      // 비어있으면 불가능
      if(pq.isEmpty()) {
        bw.write("0");
        bw.flush();
        bw.close();
        return;
      }

      // 가장 늦게 지는 꽃 선택
      int maxEnd = pq.poll();

      // 가장 늦게 지는 꽃이 현재보다 날짜가 앞일 때
      if(maxEnd < curr) {
        bw.write("0");
        bw.flush();
        bw.close();
        return;
      }

      curr = maxEnd;
      count++;
    }

    bw.write(count + "");
    bw.flush();
    bw.close();
  }

  static class Calender {
    int start, end;

    public Calender(int sm, int sd, int em, int ed) {
      start = sm * 100 + sd; // ex) 3월1일 -> 301
      end = em * 100 + ed;
    }
  }
}
