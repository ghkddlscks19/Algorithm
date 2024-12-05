import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int statedChess[] = new int[]{1, 1, 2, 2, 2, 8};
        int length = statedChess.length;
        int inputChess[] = new int[statedChess.length];
        int result[] = new int[statedChess.length];

        for(int i =0; i<length; i++){
            inputChess[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<length; i++) {
            result[i] = statedChess[i] - inputChess[i];
            System.out.print(result[i] + " ");
        }
    }
}