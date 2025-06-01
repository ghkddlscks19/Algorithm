import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int arr[] = new int[N];

    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    // 배열 정렬
    Arrays.sort(arr);
    
    // 두 수의 합을 구한 리스트 만들기
    List<Integer> twoSum = new ArrayList<>();
    // 중복 허용 해야함
    for(int i =0; i<N; i++) {
      for(int j =i; j<N; j++) {
        twoSum.add(arr[i] + arr[j]);
      }
    }
    // 리스트 정렬
    Collections.sort(twoSum);

    // x + y + z = k -> x + y = k - z
    for(int i = N-1; i>=0; i--) {
      for(int j =0; j<N; j++) {
        int target = arr[i] - arr[j];
        int left = 0;
        int right = twoSum.size() - 1;

        while(left <= right) {
          int mid = (left + right) / 2;
          if(twoSum.get(mid) < target) {
            left = mid + 1;
          } else if(twoSum.get(mid) == target) {
            bw.write(String.valueOf(arr[i]));
            bw.flush();
            bw.close();
            return;
          } else {
            right = mid - 1;
          }
        }
      }
    }
  }
}
