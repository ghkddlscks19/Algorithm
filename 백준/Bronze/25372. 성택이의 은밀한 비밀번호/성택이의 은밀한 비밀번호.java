import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for(int i =0; i<N; i++) {
      String pwd = br.readLine();

      if(pwd.length() >= 6 && pwd.length() <= 9) {
        bw.write("yes");
      } else {
        bw.write("no");
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();

    
  }
}
