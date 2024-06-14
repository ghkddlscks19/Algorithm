import java.util.*;
import java.io.*;

class Main {
    //최대값
    static int max = Integer.MIN_VALUE;
    //최소값
    static int min = Integer.MAX_VALUE;
    //숫자
    static int number[];
    //숫자 개수
    static int n;
    //연산자 개수
    static int operator[] = new int[4];

    static void dfs(int num, int depth){
        if(number.length == depth){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        for(int i =0; i<4; i++){
            if(operator[i] > 0){
                //연산자 감소
                operator[i]--;

                switch (i){
                    case 0: dfs(num+number[depth], depth+1);
                            break;
                    case 1: dfs(num-number[depth], depth+1);
                            break;
                    case 2: dfs(num*number[depth], depth+1);
                            break;
                    case 3: dfs(num/number[depth], depth+1);
                            break;
                }
                //dfs 끝나면 다시 연산자 복구
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
}