import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    HashSet<String> dancingList = new HashSet<>();
    dancingList.add("ChongChong");

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      String b = st.nextToken();

      // a가 댄싱 리스트에 있을 때
      if(dancingList.contains(a)) {
        dancingList.add(b);
      }
      // b가 댄싱 리스트에 있을 때
      else if(dancingList.contains(b)) {
        dancingList.add(a);
      }
    }

    bw.write(dancingList.size() + "");
    bw.flush();
    bw.close();
    
  }
}
