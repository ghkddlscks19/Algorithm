import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static String s;
    static char input[], code[];
    static int arr[][];

    public void dfs(int depth, int start) {
        if (depth == L) {
            if (isCode(code)) {
                for (char c : code) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        } else {
            for (int i = start; i < C; i++) {
                code[depth] = input[i];
                dfs(depth + 1, i + 1);
            }
        }
    }

    public Boolean isCode(char code[]) {
        int c = 0;
        int v = 0;

        for (int i = 0; i < code.length; i++) {
            if(code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') v++;
            else c++;
        }
        if(v>=1 && c>=2) return true;
        else return false;
    }



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        code = new char[L];
        input = new char[C];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        T.dfs(0, 0);


    }
}
