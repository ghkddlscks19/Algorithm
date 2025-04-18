import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int arr[] = new int[3];

    for(int i =0; i<arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    for(int x : arr) {
      bw.write(x + " ");
    }

    bw.flush();
    bw.close();
    
  }
}
