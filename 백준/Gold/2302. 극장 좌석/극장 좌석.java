  import java.util.*;
  import java.io.*;
  public class Main{
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
      int N = Integer.parseInt(br.readLine()); // 좌석의 개수
      int M = Integer.parseInt(br.readLine()); // 고정석의 개수

      // 경우의 수가 피보나치랑 동일
      int dp[] = new int[N+1];
      dp[0] = dp[1] = 1;
      
      for(int i =2; i<=N; i++) {
        dp[i] = dp[i-2] + dp[i-1];
      }

      List<Integer> fixed = new ArrayList<>();
      fixed.add(0); // 가상의 좌석 추가 (계산 통일을 위함)

      for(int i =0; i<M; i++) {
        fixed.add(Integer.parseInt(br.readLine()));
      }
      
      fixed.add(N+1); // 가상의 좌석 추가 (계산 통일을 위함)

      int result = 1;
      for(int i =1; i<fixed.size(); i++) {
        int gap = fixed.get(i) - fixed.get(i-1) - 1;
        if(gap > 0) { // 곱셈이라 0이면 안됨
          result *= dp[gap];        
        }
      }

      bw.write(String.valueOf(result));
      bw.flush();
      bw.close();
    }
  }
