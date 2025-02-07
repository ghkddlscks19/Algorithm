import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    HashMap<Integer, Integer> hmX = new HashMap<>();
    HashMap<Integer, Integer> hmY = new HashMap<>(); 

    for(int i =0; i<3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      hmX.put(x, hmX.getOrDefault(x, 0) + 1);
      hmY.put(y, hmY.getOrDefault(y, 0) + 1);     
    }

    StringBuilder sb = new StringBuilder();
    for(int x : hmX.keySet()) {
      if(hmX.get(x) == 1) {
        sb.append(x + " ");
      }
    }

    for(int y : hmY.keySet()) {
      if(hmY.get(y) == 1) {
        sb.append(y);
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();   
  }
}
