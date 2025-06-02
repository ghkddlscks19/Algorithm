import java.util.*;
import java.io.*;

public class Main {
  static class Jewel {
    int weight;
    int value;
    
    Jewel(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }   
  }
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Jewel jewels[] = new Jewel[N];
    for(int i =0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      jewels[i] = new Jewel(M, V);
    }

    int bags[] = new int[K];
    for(int i =0; i<K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }
    
    // 무게 기준 오름차순으로 정렬
    Arrays.sort(jewels, (o1, o2) -> {
      return o1.weight - o2.weight;
    });

    // 가방 무게도 오름차순 정렬
    Arrays.sort(bags);

    // 가치 기준 내림차순 정렬
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    long answer = 0;
    int index = 0;
    for(int i =0; i<K; i++) {
      int capacity = bags[i];

      // 현재 가방에 넣을 수 있는 보석 모두 넣기
      while(index < N && capacity >= jewels[index].weight) {
        pq.add(jewels[index].value);
        index++;
      }

      // 비어 있지 않다면 가치 뽑아내기
      if(!pq.isEmpty()) {
        answer += pq.poll();
      }
    }
    
    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }
}