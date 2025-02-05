import java.util.*;
import java.io.*;

//  10^6
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    while(true) {
      StringBuilder sb = new StringBuilder();
      int n = Integer.parseInt(br.readLine());
      if(n == -1) break; // -1이면 멈추기

      sb.append(n + " = 1");

      int sum = 1;
      for(int i =2; i<n; i++) {
        if(n % i == 0) { // 나누어 떨어지면 answer에 더해서 누적
          sb.append(" + " + i);
          sum += i;
        }
      }

      if(sum == n) bw.write(sb.toString() + "\n");
      else bw.write(n + " is NOT perfect." + "\n");
    }

    
    bw.close();

  }
}
