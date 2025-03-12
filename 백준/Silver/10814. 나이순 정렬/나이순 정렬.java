import java.util.*;
import java.io.*;

public class Main{
  static class Info {
    int age;
    String name;

    public Info(int age, String name) {
      this.age = age;
      this.name = name;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    
    List<Info> list = new ArrayList<>();

    for(int i =0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      list.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken()));
    }

    Collections.sort(list, (p1, p2) -> p1.age - p2.age);

    for(Info user: list) {
      bw.write(user.age + " " + user.name + "\n");
    }
    
    bw.flush();
    bw.close();
  }
}
