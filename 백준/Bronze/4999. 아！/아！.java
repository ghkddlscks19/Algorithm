import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String jaeHwan = br.readLine();
    String doctor = br.readLine();

    if(jaeHwan.length() < doctor.length()) bw.write("no");
    else bw.write("go");

    bw.flush();
    bw.close();
    
  }
}
