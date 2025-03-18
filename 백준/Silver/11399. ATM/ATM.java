import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int p[] = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {    
      p[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(p);

    // 합을 넣어놓을 배열, 첫 번째 값은 넣어주기
    int sum[] = new int[N];
    sum[0] = p[0];

    int answer = 0;

    for(int i =1; i<N; i++) {
      sum[i] = sum[i-1] + p[i]; 
    }

    for(int x : sum) {
      answer += x;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
