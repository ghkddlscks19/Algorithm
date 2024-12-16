import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[][] = new int[9][9];
        int max = 0, row = 1, col = 1;

        for(int i =0; i<arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<arr.length; i++) {
            for(int j =0; j<arr[i].length; j++) {
                if(max < arr[i][j]) {
                    max = arr[i][j];
                    row = i+1;
                    col = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + col);
    }
}