import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int arr[] = new int[10];
    
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    String mul = String.valueOf(a * b * c);

    for(int i =0; i<mul.length(); i++) {
      if(mul.charAt(i) == '0') arr[0]++;
      else if(mul.charAt(i) == '1') arr[1]++;
      else if(mul.charAt(i) == '2') arr[2]++;
      else if(mul.charAt(i) == '3') arr[3]++;
      else if(mul.charAt(i) == '4') arr[4]++;
      else if(mul.charAt(i) == '5') arr[5]++;
      else if(mul.charAt(i) == '6') arr[6]++;
      else if(mul.charAt(i) == '7') arr[7]++;
      else if(mul.charAt(i) == '8') arr[8]++;
      else arr[9]++;
    }

    for(int x : arr) {
      bw.write(x + "\n");
    }

    bw.flush();
    bw.close();

    
  }
}
