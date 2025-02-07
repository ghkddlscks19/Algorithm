import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int maxX = -10001;
    int maxY = -10001;
    int minX = 10001;
    int minY = 10001;

    int N = Integer.parseInt(br.readLine());
    
    
    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      // x 최대,최소 / y 최대,최소 구하기
      maxX = Math.max(maxX, x);
      maxY = Math.max(maxY, y);
      minX = Math.min(minX, x);
      minY = Math.min(minY, y);
           
    }

    int area = (maxX - minX) * (maxY - minY);
    bw.write(area + "");
    bw.flush();
    bw.close();
  }
}
