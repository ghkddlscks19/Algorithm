import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // 25센트 10센트 5센트 1센트 손님이 받는 동전 개수 최소화
        int coin[] = new int[4];

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            
            int quarter = input / 25;
            input %= 25;

            int dime = input / 10;
            input %= 10;

            int nickel = input / 5;
            input %= 5;

            int penny = input;
            
            bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
            bw.flush();
        }
    }
}