import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int N = Integer.parseInt(br.readLine());

    for(int i =0; i<N; i++) {
      String input = br.readLine(); // 입력

      if(input.contains("push")) { // push
        String words[] = input.split(" "); // 단어 분리
        queue.offer(Integer.parseInt(words[1]));
      } else if(input.equals("pop")) { // 정수 빼고 출력, 없으면 -1
        if(queue.isEmpty()) {
          bw.write("-1");
          bw.newLine();
        } else {
          bw.write(queue.poll() + "");
          bw.newLine();
        }
      } else if(input.equals("size")) {
        bw.write(queue.size() + "");
        bw.newLine();
      } else if(input.equals("empty")) {
        if(queue.isEmpty()) {
          bw.write("1");
          bw.newLine();
        } else {
          bw.write("0");
          bw.newLine();
        }
      } else if(input.equals("front")) {
        if(queue.isEmpty()) {
          bw.write("-1");
          bw.newLine();
        } else {
          bw.write(queue.getFirst() + "");
          bw.newLine();
        }
      } else if(input.equals("back")) {
        if(queue.isEmpty()) {
          bw.write("-1");
          bw.newLine();
        } else {
          bw.write(queue.getLast() + "");
          bw.newLine();
        }
      }
    }

    bw.flush();
    bw.close();
  }
}
