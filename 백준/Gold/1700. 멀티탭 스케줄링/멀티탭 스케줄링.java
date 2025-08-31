import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int plug[] = new int[K];
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<K; i++) {
      plug[i] = Integer.parseInt(st.nextToken());
    }

    HashSet<Integer> multitap = new HashSet<>(); // 중복 확인을 위함
    int unplugs = 0; // 플러그를 뽑은 횟수

    for(int i =0; i<K; i++) {
      int curr = plug[i];

      // 이미 있으면 넘어가기
      if(multitap.contains(curr)) {
        continue;
      }

      // 멀티탭에 자리가 있으면 꽂기
      if(multitap.size() < N) {
        multitap.add(curr);
        continue;
      }

      // 멀티탭이 가득 찼을 때 뽑을 기기를 선택해야함
      // 앞으로 안쓰이거나, 가장 늦게 사용되는 기기를 찾아야함
      int remove = -1, maxIdx = -1;
      for(int p : multitap) {
        int next = -1;
        for(int j =i+1; j<K; j++) {
          if(plug[j] == p) {
            next = j;
            break;
          }
        }

        // 앞으로 안 쓰이면 바로 선택
        if(next == -1) {
          remove = p;
          break;
        }
        
        // 가장 늦게 사용되는 것 찾기
        if(next > maxIdx) {
          maxIdx = next;
          remove = p;
        }
      }

      multitap.remove(remove);
      multitap.add(curr);
      unplugs++;
      
    }

    bw.write(unplugs + "");
    bw.flush();
    bw.close();
    
  }
}
