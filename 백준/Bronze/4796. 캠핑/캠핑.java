import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";

    int i = 1;
    while(!(input = br.readLine()).equals("0 0 0")) {
      StringTokenizer st = new StringTokenizer(input);
      
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      
      int answer = (V / P) * L + Math.min((V % P), L);  

      bw.write("Case " + i + ": " + answer);
      bw.newLine();
      i++;
    }

    bw.flush();
    bw.close();
    
  }
}
