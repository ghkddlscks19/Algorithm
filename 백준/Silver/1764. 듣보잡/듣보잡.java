import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> noEar = new HashMap<>();
    HashMap<String, Integer> noSee = new HashMap<>();

    for(int i =0; i<N; i++) {
      String name = br.readLine();
      noEar.put(name, noEar.getOrDefault(name, 0) + 1);
    }

    for(int i =0; i<M; i++) {
      String name = br.readLine();
      noSee.put(name, noSee.getOrDefault(name, 0) + 1);
    }

    int count = 0;
    List<String> list = new ArrayList<>();
    // 듣도 못한 사람 명단을 돌면서 보도 못한 명단에 있으면 카운트 추가 및 리스트에 추가
    for(String name: noEar.keySet()) {
      if(noSee.containsKey(name)) {
        count++;
        list.add(name);
      }
    }

    Collections.sort(list);

    bw.write(count + "");
    bw.newLine();

    for(String name: list) {
      bw.write(name);
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
