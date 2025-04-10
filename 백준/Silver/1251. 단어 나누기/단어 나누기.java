import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    List<String> list = new ArrayList<>();

    // 50이 최대라 50*50으로 전부 돌아도 괜찮음
    for(int i =1; i<input.length(); i++) {
      // 3부분으로 잘라서 뒤집은 다음 리스트에 넣어주기
      for(int j = i+1; j<input.length(); j++) {
        String s1 = new StringBuilder(input.substring(0, i)).reverse().toString();
        String s2 = new StringBuilder(input.substring(i, j)).reverse().toString();
        String s3 = new StringBuilder(input.substring(j, input.length())).reverse().toString();

        String result = new StringBuilder().append(s1).append(s2).append(s3).toString();
        
        list.add(result);
        
      }
    }

    Collections.sort(list);

    bw.write(list.get(0));
    bw.flush();
    bw.close();
    
  }
}
