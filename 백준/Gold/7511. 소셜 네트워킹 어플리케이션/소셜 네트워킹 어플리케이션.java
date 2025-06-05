import java.util.*;
import java.io.*;
public class Main{
  static int parent[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for(int test_case =1; test_case<=t; test_case++) {
      bw.write("Scenario " + test_case + ":");
      bw.newLine();
      int n = Integer.parseInt(br.readLine()); 
      int k = Integer.parseInt(br.readLine()); 

      parent = new int[n];
      for(int i =0; i<n; i++) {
        parent[i] = i;
      }

      for(int i =0; i<k; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        union(a, b);
      }

      int m = Integer.parseInt(br.readLine());

      for(int i =0; i<m; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(isConnected(a, b)) bw.write("1");
        else bw.write("0");
        bw.newLine();
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }

  static int find(int x) {
    if(parent[x] == x) return x;

    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    int x = find(a);
    int y = find(b);

    if(x != y) parent[y] = x;
  }

  static boolean isConnected(int a, int b) {
    return find(a) == find(b);
  }
}
