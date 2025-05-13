import java.util.*;
import java.io.*;
public class Main{
  static int N;
  static int s[][];
  static boolean selected[]; // true: 스타트팀, false: 링크팀
  static int minDiff = Integer.MAX_VALUE;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    s = new int[N][N];

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j =0; j<N; j++) {
        s[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    selected = new boolean[N];
    backtracking(0, 0);

    bw.write(minDiff + "");
    bw.flush();
    bw.close();
  }

  // count: 현재 선택한 사람 수, index: 선택 여부를 결정할 인덱스 번호
  static void backtracking(int index, int count) {
    // 인원이 다 선택되면 계산!
    if(count == N / 2) {
      calc();
      return;
    }

    // 모든 사람 다 선택여부 확인했을 때
    if(index == N) {
      return;
    }

    // 현재 인원을 스타트팀에 포함
    selected[index] = true;
    backtracking(index + 1, count + 1);

    // 현재 인원을 링크팀에 포함
    selected[index] = false;
    backtracking(index + 1, count);
  }

  static void calc() {
    int startSum = 0;
    int linkSum = 0;

    for(int i =0; i<N; i++) {
      for(int j =0; j<N; j++) {
        if(selected[i] && selected[j]) startSum += s[i][j];
        else if(!selected[i] && !selected[j]) linkSum += s[i][j];
      }
    }

    minDiff = Math.min(minDiff, Math.abs(startSum - linkSum));
  }
}
