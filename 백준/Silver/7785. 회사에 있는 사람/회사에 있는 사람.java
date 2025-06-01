import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    HashMap<String, String> hm = new HashMap<>();

    for(int i =0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String log = st.nextToken();
      hm.put(name, log);
    }

    List<String> list = new ArrayList<>();
    for(String name : hm.keySet()) {
      if(hm.get(name).equals("enter")) {
        list.add(name);
      }
    }

    Collections.sort(list, (o1, o2) -> {
      return o2.compareTo(o1);
    });

    for(String name : list) {
      bw.write(name);
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
