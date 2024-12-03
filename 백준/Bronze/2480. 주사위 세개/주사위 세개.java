import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int money = 0;

        if(a == b && b == c && c == a) money = 10000 + (a * 1000);
        else if (a == b) money = 1000 + (a * 100);
        else if (b == c) money = 1000 + (b * 100);
        else if (c == a) money = 1000 + (c * 100);
        else {
            int max = Math.max(a, Math.max(b, c));
            money = max * 100;
        }
        System.out.println(money);
    }
}