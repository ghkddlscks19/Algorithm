import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    String strSum = String.valueOf(a) + String.valueOf(b);
   
    int result1 = a + b - c;
    int result2 = Integer.parseInt(strSum) - c;

    bw.write(result1 + "\n");
    bw.write(result2 + "");
    bw.flush();
    bw.close();
    
  }
}
