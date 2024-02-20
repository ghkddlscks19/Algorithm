import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int arr[][];

    static int ch[];

    public void DFS(int start) {
        ch[start] = 1;
        System.out.print(start+" ");
        for (int i = 1; i <= n; i++) {
            if (arr[start][i] == 1 && ch[i] == 0) {
                DFS(i);
            }
        }
    }

    public void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        ch[start] = 1;

        System.out.print(start+" ");

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[poll][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    System.out.print(i + " ");
                    q.offer(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int start = sc.nextInt();

        arr = new int[n + 1][n + 1];


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        ch = new int[n + 1];
        T.DFS(start);
        ch = new int[n + 1];
        System.out.println();
        T.BFS(start);

    }
}
