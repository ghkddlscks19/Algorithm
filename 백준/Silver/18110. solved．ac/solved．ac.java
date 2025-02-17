import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int arr[] = new int[n];

    for(int i =0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int trimmed = Math.round((float) n / 20 * 3);

    int sum = 0;
    int cnt = 0;
    for(int i = trimmed; i<n-trimmed; i++) {
      sum += arr[i];
      cnt++;
    }

    bw.write(Math.round((float) sum / cnt) + "");
    bw.flush();
    bw.close();
    
  }
}
