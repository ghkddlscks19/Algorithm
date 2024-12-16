import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int tmp = 1;
        int result = 0;

        for(int i =N.length()-1; i>=0; i--) {
            char c = N.charAt(i);

            if('0' <= c && c <= '9') {
                result += (c - '0') * tmp;
            }else {
                result += (c - 'A' + 10) * tmp;
            }
            tmp *= B;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}