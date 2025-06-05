import java.util.*;
import java.io.*;
public class Main{
  static int parent[];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent= new int[n+1];

    for(int i =0; i<=n; i++) {
      parent[i] = i;
    }

    for(int i =0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int uf = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(uf == 0) {
        union(a, b);
      } else {
        if(isConnected(a, b)) bw.write("YES");
        else bw.write("NO");
        bw.newLine();
      }
    }

    bw.flush();
    bw.close();
  }

  static int find(int x) {
    if(parent[x] == x) return parent[x];

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
