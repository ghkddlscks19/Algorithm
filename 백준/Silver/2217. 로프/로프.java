import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Integer rope[] = new Integer[N];
    int min = 10001;
    for(int i =0; i<N; i++) {
      rope[i] = Integer.parseInt(br.readLine());
    }

    // 중량을 많이 들 수 있는 로프부터 선택할 수 있도록 내림차순 정렬
    Arrays.sort(rope, Collections.reverseOrder());
    
    int result = 0;
    for(int i =0; i<N; i++) {
      result = Math.max(result, rope[i] * (i+1));
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
