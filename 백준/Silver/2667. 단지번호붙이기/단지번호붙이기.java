import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, cnt;
    static int arr[][];

    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

    public void dfs(int x, int y) {
        arr[x][y] = 0;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (arr[x][y] == 1) {
                    cnt = 0;
                    T.dfs(x, y);
                    answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}
