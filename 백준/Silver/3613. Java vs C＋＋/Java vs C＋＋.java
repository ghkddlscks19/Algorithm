import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 입력 받는 문자열
    String input = br.readLine();

    // 첫 단어는 무조건 소문자여야함! 아니면 에러 줘야함!
    if(!(input.charAt(0) >= 'a' && input.charAt(0) <= 'z')) {
      bw.write("Error!");
      bw.flush();
      bw.close();
      return;
    }

    // 처음과 끝에 _가 올 수 없음
    if(input.charAt(0) == '_' || input.charAt(input.length() - 1) == '_') {
      bw.write("Error!");
      bw.flush();
      bw.close();
      return;
    }

    // false: c++, true: java
    boolean flag = false;

    // c++인지 java인지 판별
    for(int i =0; i<input.length(); i++) {
      if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
        flag = true;
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    // c++일 때
    if(!flag) {
      for(int i =0; i<input.length()-1; i++) {
        // _가 연속으로 나올 수 없음
        if(input.charAt(i) == '_' && input.charAt(i+1) == '_') {
          bw.write("Error!");
          bw.flush();
          bw.close();
          return;
        }
      }

      String words[] = input.split("_");
      sb.append(words[0]);
      for(int i =1; i<words.length; i++) {
        sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1));
      }
    } else {
      int curr = 0;
      for(int i =0; i<input.length(); i++) {
        if(input.charAt(i) == '_') {
          bw.write("Error!");
          bw.flush();
          bw.close();
          return;
        }
        if((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
          sb.append(input.substring(curr, i).toLowerCase() + "_");
          curr = i;
        }
      }
      sb.append(input.substring(curr).toLowerCase());
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    

  }
}
