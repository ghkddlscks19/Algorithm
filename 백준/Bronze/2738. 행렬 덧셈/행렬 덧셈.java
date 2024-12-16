import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a[][] = new int[N][M];
        int b[][] = new int[N][M];
        int result[][] = new int[N][M];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<N; i++) {
            for(int j =0; j<M; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        for(int i =0; i<N; i++) {
            for(int j =0; j<M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}