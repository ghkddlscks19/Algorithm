import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   

    // 1과 자기 자신을 제외한 약수 -> 진짜 약수
    // 약수 중 제일 작은거 제일 큰거 곱하면 답

    // 진짜 약수의 개수
    int num = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int min = 1000001;
    int max = 0;
    int answer = 0;
    for(int i =0; i<num; i++) {
      int div = Integer.parseInt(st.nextToken());
      min = Math.min(min, div);
      max = Math.max(max, div);
    }
    answer = min * max;
    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }
}
