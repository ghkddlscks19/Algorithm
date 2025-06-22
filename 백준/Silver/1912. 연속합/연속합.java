import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int num[] = new int[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i =1; i<=n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    int max = -1001;
    int sum = 0;
    for(int i =1; i<=n; i++) {
      sum += num[i];

      if(max < sum) max = sum;
      
      if(sum < 0) sum = 0;
    }

    System.out.println(max);
  }
}
