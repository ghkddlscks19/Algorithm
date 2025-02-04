import java.util.*;
import java.io.*;
// 10^4
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;
    while(!(input = br.readLine()).equals("0 0")) {
      StringTokenizer st = new StringTokenizer(input);
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      boolean isFactor = false;
      boolean isMultiple = false;
      if(a > b) { // 배수인지 확인
        int i = 2;
        while(a >= b * i) {
          if(a == b * i) {
            isMultiple = true;
            bw.write("multiple" + "\n");
          }
          i++;
        }       
      } else { // 약수인지 확인
        int i = 2;
        while(b >= a * i) {
          if(b == a * i) {
            isFactor = true;
            bw.write("factor" + "\n");
          }
          i++;
        }    
      }
      if(!isMultiple && !isFactor) bw.write("neither" + "\n");
      
    }
    bw.flush();
    bw.close();
  }
}
