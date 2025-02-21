import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int arr[] = new int[N];
    HashMap<Integer, Integer> hm = new HashMap<>();
    double sum = 0;
    
    for(int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine()); 
      sum += arr[i];
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }

    Arrays.sort(arr);

    ArrayList<Integer> list = new ArrayList<>();
    int maxFrequency = 0;
    for(int freq : hm.values()) {
      maxFrequency = Math.max(maxFrequency, freq);     
    }

    for(int n : hm.keySet()) {
      if(hm.get(n) == maxFrequency) list.add(n);
    }
    Collections.sort(list);

    
    bw.write((int) Math.round(sum/N) + "\n"); // 산술평균
    bw.write(arr[N/2] + "\n"); // 중앙값
    bw.write((list.size() > 1 ? list.get(1) : list.get(0)) + "\n"); // 최빈값
    bw.write((arr[N-1] - arr[0]) + "\n"); // 범위

    bw.flush();
    bw.close();
  }
}
