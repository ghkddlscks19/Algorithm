import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 100 이하의 정수
    int comNum = Integer.parseInt(br.readLine());

    int pairNum = Integer.parseInt(br.readLine());

    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
 
    for (int i =0; i<=comNum; i++) {
      list.add(new ArrayList<Integer>());
    }
    
    for(int i =1; i<=pairNum; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      // 양방향 연결
      list.get(n1).add(n2);
      list.get(n2).add(n1);
    }

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean visited[] = new boolean[comNum + 1];
    int count = 0;
    
    queue.offer(1);
    visited[1] = true;

    while(!queue.isEmpty()) {
      int poll = queue.poll();

      for(int next : list.get(poll)) {
        if(!visited[next]) {
          queue.offer(next);
          visited[next] = true;
          count++;
        }
      }
    }

    bw.write(count + "");
    bw.flush();
    bw.close();
  }

}
