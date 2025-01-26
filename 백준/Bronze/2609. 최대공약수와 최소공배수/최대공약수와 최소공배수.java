import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    //최대 공약수
    int gcd = gcd(a,b);

    //최소 공배수 = 두 수의 곱 / 최대 공약수
    int lcm = a * b / gcd;

    bw.write(gcd + "\n");
    bw.write(lcm + "\n");
    bw.flush();
    bw.close();
    

  }
  // 최대 공약수 알고리즘 (유클리드 호제법)
  static int gcd(int p, int q) {
    if(q == 0) return p;
    return gcd(q, p % q);
  }
}


