import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int arr[] = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int dp[] = new int[N];
    int parent[] = new int[N];
    Arrays.fill(parent, -1);

    int maxLen = 0;
    int maxIdx = 0;

    // 길이 계산
    for(int i =0; i<N; i++) {
      dp[i] = 1; 
      for(int j =0; j<i; j++) {
        if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          parent[i] = j; // 이전 원소 인덱스 저장
        }
      }

      if(maxLen < dp[i]) {
        maxLen = dp[i];
        maxIdx = i; // 최대 길이 끝 인덱스
      }
    }

    List<Integer> path = new ArrayList<>(); // 인덱스로 역추적
    int curr = maxIdx;

    while(curr != -1) {
      path.add(curr);
      curr = parent[curr];
    }
    Collections.reverse(path); // 역추적이라서 한번 반대로 정렬해줘야함

    bw.write(String.valueOf(maxLen));
    bw.newLine();

    for(int x : path) {
      bw.write(arr[x] + " ");
    }

    bw.flush();
    bw.close();
  }
}
