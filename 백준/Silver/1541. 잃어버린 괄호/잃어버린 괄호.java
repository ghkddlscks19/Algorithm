import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // - 기준으로 분리
    String parts[] = br.readLine().split("-");

    // 첫 숫자는 더하기
    int result = sum(parts[0]);

    // 나머지는 빼기
    for(int i =1; i<parts.length; i++) {
      result -= sum(parts[i]);
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }

  static int sum(String part) {
    String numbers[] = part.split("\\+");

    int sum = 0;

    for(String n : numbers) {
      sum += Integer.parseInt(n);
    }

    return sum;
  }
}
