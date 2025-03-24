import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int result = 0;

    while(N > 0) {
      if(N % 5 == 0) {
        result += N / 5;
        break;
      } else {
        N -= 3;
        result++;
      }
    }

    // 정확히 만들 수 없는 경우
    if(N < 0) bw.write("-1");
    else bw.write(result + "");
    
    bw.flush();
    bw.close();
  }
}
