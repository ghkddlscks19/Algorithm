import java.util.*;
import java.io.*;
// 10^4
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;
    while(!(input = br.readLine()).equals("0 0")) {
      StringTokenizer st = new StringTokenizer(input);
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(a % b == 0) {
        bw.write("multiple" + "\n");
      } else if(b % a == 0) {
        bw.write("factor" + "\n");
      } else {
        bw.write("neither" + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}
