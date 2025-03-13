import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=0; i<T; i++) {
      // 소리 입력 받기
      String input = br.readLine();
      String animal;

      // 공백으로 분리하기
      String[] sounds = input.split(" ");
          
      // 다른 동물 소리 제거
      while(!(animal = br.readLine()).equals("what does the fox say?")) {
        String[] token = animal.split(" ");
        String sound = token[2];

        // 결과 배열
        List<String> result = new ArrayList<>();

        for(String s : sounds) {
          // 같지 않은 경우 결과 리스트에 저장
          if(!s.equals(sound)) {
            result.add(s);
          }
        }

        // sounds를 result 값으로 다시 바꿔주기
        sounds = result.toArray(new String[0]);      
      }

      StringBuilder sb = new StringBuilder();

      for(int j =0; j<sounds.length; j++) {
        sb.append(sounds[j]); 

        // 마지막 아니면 띄어쓰기 넣어주기
        if(j < sounds.length - 1) {
          sb.append(" ");
        }
      }
      bw.write(sb.toString());
      bw.newLine();
    }
    
    bw.flush();
    bw.close();
  }
}
