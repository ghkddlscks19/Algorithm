import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // 양수 및 음수 저장 할 우선순위 큐! 순서 상관 없이 묶을 수 있으니까!
    PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> negative = new PriorityQueue<>();

    // 0과 1은 묶을 때 중요한 요소!
    int zeros = 0;
    int ones = 0;

    for(int i =0; i<N; i++) {
      int num = Integer.parseInt(br.readLine());

      if(num > 1) {
        positive.add(num);
      } else if(num == 1) {
        ones++;
      } else if(num == 0) {
        zeros++;
      } else {
        negative.add(num);
      }
    }

    long result = 0;

    // 양수 끼리 묶기!
    while(positive.size() > 1) {
      int first = positive.poll();
      int second = positive.poll();

      result += (long) first * second;
    }

    // 양수가 하나 남은 경우
    if(!positive.isEmpty()) {
      result += (long) positive.poll();
    }

    // 음수 처리
    while(negative.size() > 1) {
      int first = negative.poll();
      int second = negative.poll();

      result += (long) first * second;
    }

    // 음수가 하나 남은 경우
    if(!negative.isEmpty()) {
      if(zeros == 0) {
        result += negative.poll();
      }
      // 0이 있다면 음수는 0으로 만들어 주는게 좋음! 즉, 무시
    }

    result += ones;

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
