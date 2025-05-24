import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Integer A[] = new Integer[N];
    Integer B[] = new Integer[N];

    // A랑 B 배열에 넣기
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }

    // A는 최소부터 B는 최대부터 정렬해서 곱해보면 답 나옴
    Arrays.sort(A);
    Arrays.sort(B, Collections.reverseOrder());

    int result = 0;
    for(int i =0; i<N; i++) {
      result += A[i] * B[i];
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
