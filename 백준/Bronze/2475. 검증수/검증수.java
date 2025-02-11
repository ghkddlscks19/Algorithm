import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    int result = 
      ( (int) Math.pow(a, 2) +
      (int) Math.pow(b, 2) +
      (int) Math.pow(c, 2) +
      (int) Math.pow(d, 2) +
      (int) Math.pow(e, 2) ) % 10;

    bw.write(result + "");
    bw.flush();
    bw.close();
    
  }
}
