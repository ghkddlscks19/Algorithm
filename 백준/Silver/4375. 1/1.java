import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";
    int n, one, length;
    while((input = br.readLine()) != null) {
      n = Integer.parseInt(input);
      one = 1;
      length = 1;

      // 1이면 답은 1
      if(n == 1) {
        bw.write("1\n");
      } else {
        while(one != 0) {
          one = (one * 10 + 1) % n; // 1 -> 11 -> 111 (이전 수 * 10 + 1)
          length++;
        }
        bw.write(length + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}


