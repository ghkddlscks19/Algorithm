import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int position[] = new int[N+1]; // 연속된 번호의 학생들이 연속으로 서있는지 확인
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      int student = Integer.parseInt(st.nextToken());
      position[student] = i;
    }

    // 가장 긴 연속 증가 구간의 길이 찾기
    int maxLength = 1;
    int currentLength = 1;

    for (int i = 2; i <= N; i++) {
      if (position[i] > position[i-1]) {
        currentLength++;
        maxLength = Math.max(maxLength, currentLength);
      } else {
        currentLength = 1;
      }
    }

    // 마지막 구간 확인
    maxLength = Math.max(maxLength, currentLength);

    // 전체 학생 수 - 가장 긴 연속 구간의 길이 = 정답
    int result = N - maxLength;

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
