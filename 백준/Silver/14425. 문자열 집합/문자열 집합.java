import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> hm = new HashMap<>();
    List<String> list = new ArrayList<>();

    // 집합 넣어 놓기
    for(int i =0; i<N; i++) {
      hm.put(br.readLine(), 0);
    }

    // m개의 문자열을 확인해보기
    for(int i =0; i<M; i++) {
      String input = br.readLine();
      if(hm.containsKey(input)) {
        list.add(input);
      }
    }

    int answer = list.size();

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
