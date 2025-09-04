import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    int limit = 10000000;
    boolean isPrime[] = new boolean[limit + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

    for(int i =2; i*i<=limit; i++) {
      if(isPrime[i]) {
        for(int j =i*i; j<=limit; j+=i) {
          isPrime[j] = false;
        }
      }
    }

    // 소수 리스트
    List<Integer> list = new ArrayList<>();
    for(int i =2; i<=limit; i++) {
      if(isPrime[i]) {
        list.add(i);
      }
    }

    long count = 0;

    // 각 소수에 대해 N 제곱 확인
    for(int prime: list) {
      long n = (long) prime * prime;

      while(n <= B) {
        if(n >= A) {
          count++;
        }

        if(n > B / prime) break;
        n *= prime;
      }
    }

    bw.write(count + "");
    bw.flush();
    bw.close();
  }
}
