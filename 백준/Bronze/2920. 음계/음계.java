import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int arr[] = new int[8];
    for(int i =0; i<8; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    boolean asc = true;
    boolean desc = true;
    for(int i =0; i<7; i++) {
      if(arr[i] < arr[i+1]) desc = false;
      if(arr[i+1] < arr[i]) asc = false;   
    }

    if(asc) bw.write("ascending");
    else if(desc) bw.write("descending");
    else bw.write("mixed");

    bw.flush();
    bw.close();
  }
}
