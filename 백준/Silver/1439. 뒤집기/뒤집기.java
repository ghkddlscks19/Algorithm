import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();

    int zeroCnt = 0;
    int oneCnt = 0;

    if(input.charAt(0) == '0') {
      zeroCnt++;
    } else {
      oneCnt++;
    }

    for(int i =1; i<input.length(); i++) {
      if(input.charAt(i) != input.charAt(i-1)) {
        if(input.charAt(i) == '0') {
          zeroCnt++;
        } else {
          oneCnt++;
        }
      }
    }

    int result = Math.min(zeroCnt, oneCnt);

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
