import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<Member> list = new ArrayList<>();
    for(int i =0; i<3; i++) {
      String input[] = br.readLine().split(" ");
      int p = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);
      String s = input[2];

      list.add(new Member(p, y, s));
    }
    // 세 참가자의 입학 연도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열
    Collections.sort(list, (o1, o2) -> {
      return o1.y - o2.y;
    });

    for(Member m : list) {
      bw.write((m.y % 100) + "");
    }
    bw.newLine();

    // 세 참가자 중 성씨를 영문으로 표기했을 때의 첫 글자를 백준 온라인 저지에서 해결한 문제가 많은 사람부터 차례대로 나열한 문자열
    Collections.sort(list, (o1, o2) -> {
      return o2.p - o1.p;
    });

    for(Member m : list) {
      bw.write(m.s.toString().charAt(0));
    }

    bw.flush();
    bw.close();
  }

  static class Member {
    int p, y;
    String s;

    public Member(int p, int y, String s) {
      this.p = p;
      this.y = y;
      this.s = s;
    }
  }
}
