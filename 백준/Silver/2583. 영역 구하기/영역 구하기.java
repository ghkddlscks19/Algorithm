import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int m, n, k, cnt;
    static int arr[][];

    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

    public void dfs(int x, int y) {
        arr[x][y] = 1;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[m][n];

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int k = y1; k < y2; k++) {
                for (int j = x1; j < x2; j++) {
                    arr[k][j] = 1;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (arr[x][y] == 0) {
                    cnt = 0;
                    T.dfs(x, y);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
