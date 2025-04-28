import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String docs = br.readLine();
    String command = br.readLine();

    // docs에 있는 command를 다 1로 치환 후 1의 개수 구하기
    docs = docs.replace(command, "1");

    int answer = 0;
    
    for(int i =0; i<docs.length(); i++) {
      if(docs.charAt(i) == '1') answer++;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
