import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int L = Integer.parseInt(br.readLine());

    int answer = 0;

    while(L>0) {
      if(L >= 5) {
        L -= 5;
      } else if(L >= 4) {
        L -= 4;
      } else if(L >= 3) {
        L -= 3;
      } else if(L >= 2) {
        L -= 2;
      } else {
        L -= 1;
      }
      answer++;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
