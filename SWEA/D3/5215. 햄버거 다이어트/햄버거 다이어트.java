import java.io.*;
import java.util.*;

public class Solution {
    static int n, l, t, k, sum;
    static int score[], kcal[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test =1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            score = new int[n];
            kcal = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                t = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                score[i] = t;
                kcal[i] = k;
            }
            sum = 0;
            dfs(0, 0, 0);
            bw.write("#" + test + " " + sum);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int index, int scoreSum, int kcalSum) {
        if (kcalSum > l) return;

        sum = Math.max(sum, scoreSum);

        if(index == n) return;

        // 현재 재료 선택
        dfs(index + 1, score[index] + scoreSum, kcal[index] + kcalSum);

        // 현재 재료 선택 x
        dfs(index + 1, scoreSum, kcalSum);
    }
}