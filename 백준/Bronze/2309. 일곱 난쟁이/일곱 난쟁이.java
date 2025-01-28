import java.util.*;
import java.io.*;

public class Main{

  public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int arr[] = new int[9];
    int sum = 0;
    for(int i =0; i<9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }

    Arrays.sort(arr);

    int a = 0, b = 0;

    for(int i =0; i<arr.length-1; i++) {
      for(int j =i+1; j<arr.length; j++) {
        if(sum - arr[i] - arr[j] == 100) {
          // 일곱 난쟁이가 100인 경우 인덱스 확인해서 저장
          a = i;
          b = j;
          break;
        }
      }
    }
    
    for(int i=0;i<arr.length;i++) {     
        if(i!=a && i!=b) {
            bw.write(arr[i] + "\n");
        }
    }

    bw.flush();
    bw.close();
  }
  
}


