import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = "";
    
    while(!(input = br.readLine().toLowerCase()).equals("#")) {
      int answer = 0;

      for(int i =0; i<input.length(); i++) {
        if(input.charAt(i) == 'a' || input.charAt(i) == 'e' ||
          input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
          answer++;
        }
      }

      bw.write(answer + "\n");
    }

    bw.flush();
    bw.close();
    
  }
}
