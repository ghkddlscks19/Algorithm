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

    int sorted[] = Arrays.stream(arr)
      .distinct()
      .sorted()
      .toArray();

    for(int i =0; i<N; i++) {
      int left = 0;
      int right = sorted.length - 1;
      int target = arr[i];
      while(left <= right) {
        int mid = (left + right) / 2;
        if(sorted[mid] < target) {
          left = mid + 1;
        } else if(sorted[mid] == target) {
          bw.write(mid + " ");
          break;
        } else {
          right = mid - 1;
        }
      } 
    }
    bw.flush();
    bw.close();
  }
}
