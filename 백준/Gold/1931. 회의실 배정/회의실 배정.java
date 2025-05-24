import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine()); // 회의 개수

    List<Time> list = new ArrayList<>();
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken()); // 시작 시간
      int end = Integer.parseInt(st.nextToken()); // 끝 시간

      list.add(new Time(start, end)); // 리스트에 추가
    }

    // 리스트를 끝나는 시간이 빠른 순으로 일단 정렬
    Collections.sort(list, (o1, o2) -> {
      if(o1.end == o2.end) {
        return o1.start - o2.start; // 끝나는 시간이 같으면 시작 시간이 빠른 순
      }
      return o1.end - o2.end;
    });

    int end = list.get(0).end, cnt = 1;
    for(int i =1; i<list.size(); i++) {
      if(list.get(i).start >= end) {
        end = list.get(i).end;
        cnt++;
      }
    }

    System.out.println(cnt);
  }

  static class Time {
    int start, end;

    public Time(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
