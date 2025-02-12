import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";
    while(!(input = br.readLine()).equals("0")) {
      StringBuilder sb = new StringBuilder(input);
      if(input.equals(sb.reverse().toString())) bw.write("yes" + "\n");
      else bw.write("no" + "\n");
    }

    bw.flush();
    bw.close();
  }
}
