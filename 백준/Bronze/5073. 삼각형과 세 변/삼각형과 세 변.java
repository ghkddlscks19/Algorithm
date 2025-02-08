import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";
    while(!(input = br.readLine()).equals("0 0 0")) {
      StringTokenizer st = new StringTokenizer(input);

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int sum = a + b + c;
      int max = Math.max(a, Math.max(b, c));
      
      if(a == b && b == c && c == a) bw.write("Equilateral" + "\n");
      else if(a == b || b == c || c == a){
        if(sum - max <= max) bw.write("Invalid" + "\n");
        else bw.write("Isosceles" + "\n");
      } 
      else if (a != b && b != c && c != a) {
        if(sum - max <= max) bw.write("Invalid" + "\n");
        else bw.write("Scalene" + "\n");
      }
      
    }

    bw.flush();
    bw.close();
  }
}
