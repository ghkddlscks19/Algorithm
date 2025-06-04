import java.util.*;
import java.io.*;
public class Main{
  static char left[], right[];
  static StringBuilder sb = new StringBuilder();
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    left = new char[N+1];
    right = new char[N+1];
    
    for(int i =1; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char n = st.nextToken().charAt(0);
      char l = st.nextToken().charAt(0);
      char r = st.nextToken().charAt(0);

      left[n - 'A'] = l;
      right[n - 'A'] = r;
    }

    preorder('A');
    sb.append('\n');

    inorder('A');
    sb.append('\n');

    postorder('A');
    sb.append('\n');

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static void preorder(char node) {
    if(node == '.') return;
    sb.append(node);
    preorder(left[node - 'A']);
    preorder(right[node - 'A']);
  }

  static void inorder(char node) {
    if(node == '.') return;
    inorder(left[node - 'A']);
    sb.append(node);
    inorder(right[node - 'A']);
  }

  static void postorder(char node) {
    if(node == '.') return;
    postorder(left[node - 'A']);
    postorder(right[node - 'A']);
    sb.append(node);
  }
}
