import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //맨 위 부터 중간까지
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N-i; j++) {
                sb.append(" ");
            }
            for(int k = 1; k <= 2 * i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int i = N-1; i>=1; i--){
            for(int j = 1; j <= N-i; j++) {
                sb.append(" ");
            }
            for(int k = 1; k <= 2 * i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}