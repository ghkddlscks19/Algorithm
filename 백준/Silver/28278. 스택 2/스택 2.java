import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    // N번 반복
    for(int i =0; i<N; i++) {
      String input = br.readLine();

      // 정수 X를 스택에 넣기
      if(input.startsWith("1")) {
        String num[] = input.split(" ");
        stack.push(Integer.parseInt(num[1]));
      } else if(input.startsWith("2")) { 
        // 스택에 정수가 없을 때 -1 있다면 pop 해서 출력
        if(stack.isEmpty()) {
          bw.write(-1 + "");
          bw.newLine();
        } else {
          int pop = stack.pop();
          bw.write(pop + "");
          bw.newLine();
        }
      } else if(input.startsWith("3")) {
        // 정수의 개수 출력
        bw.write(stack.size() + "");
        bw.newLine();
      } else if(input.startsWith("4")) {
        // 스택이 비어있다면 1 아니면 0 출력
        if(stack.isEmpty()) {
          bw.write(1 + "");
          bw.newLine();
        } else {
          bw.write(0 + "");
          bw.newLine();          
        }
      } else {
        // 스택에 정수가 있다면 맨 위 정수 출력, 없다면 -1 출력
        if(stack.isEmpty()) {
          bw.write(-1 + "");
          bw.newLine();
        } else {
          bw.write(stack.peek() + "");
          bw.newLine();          
        }
      }
    }
    bw.flush();
    bw.close();
  }
}
