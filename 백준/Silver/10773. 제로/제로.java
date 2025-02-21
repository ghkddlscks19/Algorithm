import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int K = Integer.parseInt(br.readLine());

    int sum = 0;
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for(int i =0; i<K; i++) {
      int num = Integer.parseInt(br.readLine());
      if(num != 0) stack.push(num);
      else stack.pop();
    }

    for(int x : stack) {
      sum += x;
    }
    bw.write(sum + "");
    bw.flush();
    bw.close();
  }
}
