import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int i =0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for(int i =0; i<M; i++) {
      int num = Integer.parseInt(st.nextToken());
      int result = hm.getOrDefault(num, 0);
      bw.write(result + " ");
    }

    bw.flush();
    bw.close();
  }
}
