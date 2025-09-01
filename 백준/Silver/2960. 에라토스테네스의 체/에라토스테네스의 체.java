import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    boolean erased[] = new boolean[N+1];
    int cnt = 0;
    for(int i =2; i<=N; i++) {
      if(!erased[i]) {
        for(int j =i; j<=N; j+=i) {
          if(!erased[j]) {
            erased[j] = true;
            cnt++;
            if(cnt == K) {
              bw.write(j + "");
              bw.flush();
              bw.close();
              return;
            }            
          }
        }        
      }
    }
  }
}
