import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    HashMap<String, Integer> hm1 = new HashMap<>();
    HashMap<Integer, String> hm2 = new HashMap<>();
    
    for(int i =1; i<=N; i++) {
      String pkm = br.readLine();
      hm1.put(pkm, i);
      hm2.put(i, pkm);
    }

    for(int i =0; i<M; i++) {
      String input = br.readLine();
      if(input.charAt(0) >= '1' && input.charAt(0) <= '9') {
        int num = Integer.parseInt(input);
        bw.write(hm2.get(num) + "\n");
      } else {
        bw.write(hm1.get(input) + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
