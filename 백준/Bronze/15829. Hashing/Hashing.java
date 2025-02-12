import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int L = Integer.parseInt(br.readLine());
    String input = br.readLine();

    int result = 0;
    for(int i =0; i<input.length(); i++) {
      result += ((int) (input.charAt(i) - 'a' + 1)* Math.pow(31, i)) % 1234567891;
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
