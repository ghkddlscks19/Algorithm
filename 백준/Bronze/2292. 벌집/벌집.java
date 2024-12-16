import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int sum = 6;
        int result = 1;

        while(true) {
            if(N<=cnt) {
                break;
            }
            cnt += sum;
            sum += 6;
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}