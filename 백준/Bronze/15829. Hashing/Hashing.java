import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int L = Integer.parseInt(br.readLine());
    String input = br.readLine();

    long result = 0;
    int m = 1234567891;
    long pow = 1;
    for(int i =0; i<input.length(); i++) {
      char alphabet = input.charAt(i);
      int num = (int) alphabet - 'a' + 1;
      result += num * pow;
      pow = 31 * pow % m;
    }

    bw.write(result % m + "");
    bw.flush();
    bw.close();
  }
}
