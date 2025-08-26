import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int M = Integer.parseInt(br.readLine());

    Delivery list[] = new Delivery[M];
    for(int i =0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int box = Integer.parseInt(st.nextToken());

      list[i] = new Delivery(start, end, box);
    }

    // 도착점 순서로 나열
    Arrays.sort(list, (a, b) -> {
        if(a.end != b.end) return a.end - b.end;
        return a.start - b.start;  
    });

    // 각 구간 별 적재량
    int truck[] = new int[N+1];
    int result = 0;
    
    for(Delivery d: list) {
      
      int maxBox = C; // 현재 담을 수 있는 최대 박스양
      
      for(int i =d.start; i<d.end; i++) {
        maxBox = Math.min(maxBox, C-truck[i]);
      }

      int loadBox = Math.min(d.box, maxBox); // 실제로 트럭에 적재될 박스 수

      // 트럭에 박스 적재
      for(int i =d.start; i<d.end; i++) {
        truck[i] += loadBox;
      }

      result += loadBox;
    }

    bw.write(result + "");
    bw.flush();
  }

  static class Delivery {
    int start, end, box;

    public Delivery(int start, int end, int box) {
      this.start = start;
      this.end = end;
      this.box = box;
    }
  }
}
