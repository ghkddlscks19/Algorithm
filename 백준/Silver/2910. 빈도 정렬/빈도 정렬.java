import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    // 숫자, 빈도수 담을 해시맵
    HashMap<Integer, Integer> map = new HashMap<>();

    // 순서 담을 해시맵
    HashMap<Integer, Integer> orderMap = new HashMap<>();
    
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
      if(!orderMap.containsKey(num)) {
        orderMap.put(num, i);
      }
    }   

    
    // 원소들 담을 리스트
    List<Integer> list = new ArrayList<>(map.keySet());

    Collections.sort(list, (o1, o2) -> {
      int cmp = map.get(o2) - map.get(o1);
      if (cmp == 0) {
        return orderMap.get(o1) - orderMap.get(o2);
      }
      return cmp;
    });


    // 빈도만큼 출력
    for(int x : list) {
      for(int i =0; i<map.get(x); i++) {
        bw.write(x + " ");
      }
    }
    
    bw.flush();
    bw.close();
    
  }
}
