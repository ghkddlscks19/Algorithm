import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sudoku[][] = new int[9][9];

    public void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    sudoku[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    public Boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == value) return false;
        }

        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == value) return false;
        }

        int small_row = (row / 3) * 3;
        int small_col = (col / 3) * 3;

        for (int i = small_row; i < small_row + 3; i++) {
            for (int j = small_col; j < small_col + 3; j++) {
                if(sudoku[i][j] == value) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.dfs(0, 0);

    }
}
