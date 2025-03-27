import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String S = br.readLine();

    for(int i =0; i<S.length(); i++) {
      bw.write(i + "\n");
    }

    bw.flush();
    bw.close();

  }

}
