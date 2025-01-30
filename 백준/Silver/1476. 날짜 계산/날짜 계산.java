import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input);

    // 입력 값
    int E = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 시작 값
    int startE = 1;
    int startS = 1;
    int startM = 1;

    int answer = 1;

    while(true) {
      if (startE > 15) {
        startE = 1;
      }
      if (startS > 28) {
        startS = 1;
      }
      if (startM > 19) {
        startM = 1;
      }
      if(E == startE && S == startS && M == startM) {
        break;
      }

      startE++;
      startS++;
      startM++;

      answer++;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}


