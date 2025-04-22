import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int R = Integer.parseInt(br.readLine());

    boolean[][] map = new boolean[R][R];
    map[a][b] = true;
    int time = 0;
    
    while(true) {
      time++;
      if(a + b + 2 < R) {
        a++;
        b++;
      } else {
        a /= 2;
        b /= 2;
      }
      if(map[a][b]) {
        bw.write(time + "");
        break;
      }
      map[a][b] = true;
      
    } 

    bw.flush();
    bw.close();
  }
}
