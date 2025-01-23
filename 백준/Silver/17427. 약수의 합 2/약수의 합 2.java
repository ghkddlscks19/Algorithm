import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      // f(1) = 1, f(2) = 3, f(3) = 4, f(4) = 7 f(5) = 6
      // f(6) = 12 f(7) = 8, f(8) = 15, f(9) = 13, f(10) = 18
      // g(10) = 1 + 3 + 4 + 7 + 6 + 12 + 8 + 15 + 13 + 18 = 87

      // 시간 복잡도: 입력 최대 10^6 -> 2중 for문은 초과

      int N = Integer.parseInt(br.readLine());
      long sum = 0;
      // 1의배수 * 개수 + 2의배수 * 개수 + ... + N의배수 * 개수
      for(int i =1; i<=N; i++) {
        sum += i * (N / i);
      }
      bw.write(String.valueOf(sum));
      bw.flush();
      bw.close();
    }
}

