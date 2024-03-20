import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, max = 0;
    static char input[][];
    static boolean visit[];

    static int dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1};

    public void dfs(int r, int c, int len) {
        visit[input[r][c] - 'A'] = true;
        max = Math.max(len, max);
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && visit[input[nr][nc] - 'A'] == false) {
                dfs(nr, nc, len + 1);
                visit[input[nr][nc] - 'A'] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                input[i][j] = s.charAt(j);
            }
        }

        visit = new boolean[26];

        T.dfs(0, 0, 1);

        System.out.println(max);

    }
}
