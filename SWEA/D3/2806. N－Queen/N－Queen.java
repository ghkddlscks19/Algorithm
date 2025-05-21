import java.util.*;
import java.io.*;
public class Solution {
    static int N, cnt;
    static int board[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T  = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N];
            cnt = 0;
            dfs(0);
            bw.write("#" + test_case + " " + cnt);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        // chess 판에 queen 둬보기
        for(int i =0; i<N; i++) {
            board[depth] = i;
            if(isPossible(depth)) dfs(depth+1);
        }
    }

    static boolean isPossible(int depth) {
        for(int i =0; i<depth; i++) {
            if(board[i] == board[depth] || depth - i == Math.abs(board[depth] - board[i])) return false;
        }
        return true;
    }
}