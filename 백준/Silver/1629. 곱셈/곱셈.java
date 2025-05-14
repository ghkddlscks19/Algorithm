import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Integer.parseInt(st.nextToken());
    long B = Integer.parseInt(st.nextToken());
    long C = Integer.parseInt(st.nextToken());

    long result = recursive(A, B, C);
    bw.write(result + "");
    bw.flush();
    bw.close();
  }
  static long recursive(long A, long B, long C) {
    if(B == 1) return A % C;
    long val = recursive(A, B/2, C);
    val = val * val % C;
    if(B % 2 == 0) return val;
    return val * A % C;
  }
}
