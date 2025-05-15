import java.util.*;
import java.io.*;

class Main {
    //세로는 체크 안해봐도 되서 1차원 배열로 체크 가능
    static int queen[];
    static int answer = 0;

    //dfs 순회
    static void dfs(int n, int depth){
        if(depth == n){
            answer++;
            return;
        }
        for(int i =0; i<n; i++){
            //해당 행, 열에 퀸을 둔다.
            queen[depth] = i;
            if(isValid(depth)){
                dfs(n, depth+1);
            }
        }
    }

    //가능한지 확인
    static boolean isValid(int depth){
        for(int i =0; i<depth; i++){
            //가로 확인
            if(queen[i] == queen[depth]) return false;
            //대각선 확인
            if(queen[i]-i == queen[depth]-depth || queen[i]+i == queen[depth] + depth) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queen = new int[n];
        dfs(n, 0);
        System.out.println(answer);
    }
}