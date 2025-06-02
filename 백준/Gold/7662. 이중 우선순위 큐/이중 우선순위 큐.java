import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    
    for(int i =0; i<T; i++) {
      int k = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> tm = new TreeMap<>();
      for(int j =0; j<k; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String op = st.nextToken();
        int num = Integer.parseInt(st.nextToken());

        if(op.equals("I")) { // 삽입 연산       
          tm.put(num, tm.getOrDefault(num, 0) + 1);
        } else { // 삭제 연산
          if(tm.isEmpty()) continue;
          if(num == -1) {
            int minKey = tm.firstKey();
            if(tm.get(minKey) == 1) {
              tm.remove(minKey);
            } else {
              tm.put(minKey, tm.get(minKey) - 1);
            }
          } else {
            int maxKey = tm.lastKey();
            if(tm.get(maxKey) == 1) {
              tm.remove(maxKey);
            } else {
              tm.put(maxKey, tm.get(maxKey) - 1);
            }
          }
        }
      }
      if(tm.isEmpty()) {
        bw.write("EMPTY");
      } else {
        bw.write(tm.lastKey() + " " + tm.firstKey());
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}
