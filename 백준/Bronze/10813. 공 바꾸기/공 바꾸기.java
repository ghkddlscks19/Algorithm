import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = arr[a-1];
            arr[a-1] = arr[b-1];
            arr[b-1] = tmp;
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }


    }
}