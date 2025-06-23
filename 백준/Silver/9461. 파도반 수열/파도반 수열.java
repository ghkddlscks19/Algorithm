import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    long arr[] = new long[101];
    arr[1] = arr[2] = arr[3] = 1;

    for(int i =4; i<=100; i++) {
      arr[i] = arr[i-3] + arr[i-2];
    }

    for(int t =0; t<T; t++) {
      int N = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(arr[N]));
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}
