import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean destroyed[] = new boolean[10];
    
    int N = Integer.parseInt(br.readLine());

    int M = Integer.parseInt(br.readLine());
    
   

    if(M > 0) {
       StringTokenizer st = new StringTokenizer(br.readLine());
      // 고장난 버튼 체크
      for(int i =0; i<M; i++) {
        int index = Integer.parseInt(st.nextToken());
        destroyed[index] = true;
      }
    }

    // 초기 값은 + 또는 -로 갈 수 있는 값으로 설정
    int answer = Math.abs(N-100);

    for(int i =0; i<=999999; i++) {
      // 현재 값
      String input = String.valueOf(i);

      boolean isBroken = false;
      // 현재 값을 누를 때 고장난게 있는지 확인
      for(int j =0; j<input.length(); j++) {
        if(destroyed[input.charAt(j) - '0']) { // 고장 났을 때
          isBroken = true;
          break;
        }
      }
      
      if(!isBroken) {
        // 가장 적은 횟수를 담기
        int min = Math.abs(N-i) + input.length();
        answer = Math.min(answer, min);
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  } 
}
