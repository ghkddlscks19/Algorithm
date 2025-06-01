import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int lines[] = new int[K]; 
    for(int i =0; i<K; i++) {
      lines[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(lines);

    // long으로 타입 설정해줘야함
    // left + right가 int 범위를 벗어날 수 있음
    long left = 1;
    long right = lines[K-1];

    while(left <= right) {
      long mid = (left + right) / 2;
      int cnt = 0;
      for(int i =0; i<K; i++) {
        cnt += (lines[i] / mid);
      }

      if(cnt < N) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    bw.write(String.valueOf(right));
    bw.flush();
    bw.close();
  }
}
