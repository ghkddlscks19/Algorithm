import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int sum = a + b + c;
    int max = Math.max(a, Math.max(b,c));

    // 삼각형 조건을 만족할 때
    if(sum - max > max) bw.write(sum + "");
    else bw.write((sum - max) * 2 - 1 + "");

    bw.flush();
    bw.close();
  }
}
