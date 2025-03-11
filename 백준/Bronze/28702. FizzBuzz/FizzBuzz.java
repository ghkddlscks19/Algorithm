import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int index = 0;
    int curr = 0;
    for(int i =1; i<=3; i++) {
      String input = br.readLine();

      if(input.charAt(0) != 'F' && input.charAt(0) != 'B') {
        index = i;
        curr = Integer.parseInt(input);
        break;
      }
    }

    int finalNum = curr + 4 - index;

    if(finalNum % 3 == 0) {
      if(finalNum % 5 == 0) bw.write("FizzBuzz");
      else bw.write("Fizz");
    } else if(finalNum % 5 == 0) {
      bw.write("Buzz");
    } else {
      bw.write(finalNum + "");
    }

    bw.flush();
    bw.close();
  }
}
