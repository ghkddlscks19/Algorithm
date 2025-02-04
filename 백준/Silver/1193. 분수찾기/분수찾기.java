import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //10^7 이중 for문 x
    
    int X = Integer.parseInt(br.readLine());

    // 현재 몇번째 줄에 해당하는지 확인하기 위한 변수
    int line = 1;


    while(X - line > 0) {
      X -= line;
      line++;
    }

    int loc = X; // 몇 번째 순서인지
    int sum = line + 1; // 분자와 분모의 합
    int bunja = 0, bunmo = 0; // 분자. 분모

    if(line % 2 ==0) { // line이 짝수면 위에서 아래 순서로 셈
      bunja = loc;
      bunmo = sum - loc;
    } else { // 홀수면 아래에서 위로 셈
      bunja = sum - loc;
      bunmo = loc;
    }

    bw.write(bunja + "/" + bunmo);

    bw.flush();
    bw.close();
  }
}
