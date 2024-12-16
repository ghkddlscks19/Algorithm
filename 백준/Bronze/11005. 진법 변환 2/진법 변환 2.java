import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int tmp = 0;

        StringBuilder sb = new StringBuilder();

        while(N > 0) {
            tmp = N % B;
            N /= B;

            if(0 <= tmp && tmp <= 9) {
                sb.append(tmp);
            } else {
                sb.append((char)(tmp + 'A' - 10));
            }
        }

        bw.write(sb.reverse().toString());
        bw.flush();
    }
}