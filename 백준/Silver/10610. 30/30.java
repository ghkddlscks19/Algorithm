import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    
    char[] digits = input.toCharArray();

    // 30의 배수 조건
    // 1. 3의 배수: 각 자릿수의 합이 3의 배수
    // 2. 10의 배수: 마지막이 0

    boolean existZero = false;
    int sum = 0;

    for(char digit: digits) {
      int num = digit - '0';
      sum += num;
      if(num == 0) {
        existZero = true;
      }
    }

    // 30의 배수 조건 확인
    if(!existZero || sum % 3 != 0) {
      bw.write("-1");
      bw.flush();
      bw.close();
      return;
    }

    Arrays.sort(digits);
    
    StringBuilder sb = new StringBuilder();
    for(int i =digits.length - 1; i>=0; i--) {
      sb.append(digits[i]);
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}
