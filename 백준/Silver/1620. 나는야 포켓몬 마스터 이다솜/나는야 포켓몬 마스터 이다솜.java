import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 숫자로 찾아야 할 때도 있고 문자로 찾아야 할 때도 있으니까 맵 2개 만들기
    HashMap<String, Integer> hm1 = new HashMap<>();
    HashMap<Integer, String> hm2 = new HashMap<>();

    // 해시맵에 넣어주기 
    for(int i =1; i<=N; i++) {
      String pkm = br.readLine();
      hm1.put(pkm, i);
      hm2.put(i, pkm);
    }

    for(int i =0; i<M; i++) {
      String input = br.readLine();
      // 포켓몬 이름으로 들어왔을 때
      if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') {
        bw.write(hm1.get(input) + "");
      } else {
        bw.write(hm2.get(Integer.parseInt(input)));
      }

      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
