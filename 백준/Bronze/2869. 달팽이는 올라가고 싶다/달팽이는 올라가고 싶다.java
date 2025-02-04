import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    // 마지막에 B만큼 내려갈 일이 없으니까 최종거리에서 -B한 거리에 하루에 갈 수 있는 거리 나눠주기
    int day = (V-B) / (A-B);

    // 나머지가 0이 아니라면 낮에 도착하지 않은 경우
    if((V-B) % (A-B) != 0) {
      day++;
	}

    bw.write(day + "");
    bw.flush();
    bw.close();
  }
}
