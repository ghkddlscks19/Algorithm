import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 나무 넣어놓을 배열
    int arr[] = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i =0; i<N; i++) {  
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 이분탐색을 위한 정렬
    Arrays.sort(arr);
    int left = 0;
    int right = arr[N-1];
    int result = 0;
    while(left <= right) {
      int mid = (left + right) / 2;
      long sum = 0;
      for(int i =0; i<N; i++) {
        if(arr[i] > mid) sum += (arr[i] - mid); 
      }
      if(sum >= M) { // 목표량 이상의 나무를 얻을 수 있는 경우
        result = mid; // 현재 높이를 기록
        left = mid + 1; // 더 높은 절단기 높이를 탐색
      } else { // 목표량보다 적은 나무를 얻는 경우
        right = mid - 1; // 더 낮은 절단기 높이를 탐색
      }    
    }

    bw.write(result + "");
    bw.flush();
    bw.close();
  }
}
