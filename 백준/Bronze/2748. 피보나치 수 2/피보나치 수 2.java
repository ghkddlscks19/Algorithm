import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    long arr[] = new long[91];

    arr[1] = arr[2] = 1L;

    for(int i =3; i<=90; i++) {
      arr[i] = arr[i-2] + arr[i-1];
    }

    bw.write(String.valueOf(arr[n]));
    bw.flush();
    bw.close();
  }
}
