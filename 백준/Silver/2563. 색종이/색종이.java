import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[101][101];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int result = 0;
        for(int i = 1; i < 101; i++) {
            for(int j = 1; j < 101; j++) {
                if(arr[i][j] == 1) {
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}