import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, String> hm = new HashMap<>();

    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      hm.put(st.nextToken(), st.nextToken());
    }

    for(int i =0; i<M; i++) {
      String pwd = hm.get(br.readLine());
      bw.write(pwd);
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
