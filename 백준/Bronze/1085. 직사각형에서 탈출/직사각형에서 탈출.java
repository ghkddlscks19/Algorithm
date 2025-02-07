import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int answer = 0;

    answer = Math.min(x-0, Math.min(y-0, Math.min(w-x, h-y)));

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
