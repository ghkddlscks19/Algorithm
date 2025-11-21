import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
    
        for(int test_case = 1; test_case <= T; test_case++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            
            char arr[][] = new char[H][W];
            
            // 격자판 넣기
            for(int i = 0; i < H; i++) {
                String input = sc.next();
                for(int j = 0; j < W; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }
            
            // 전부 블랙인지 체크
            boolean allBlack = true;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(arr[i][j] == '.') {
                        allBlack = false;
                        break;
                    }
                }
                if(!allBlack) break;
            }
            
            // 전부 블랙이면 Math.min(H, W) 출력하고 다음 테케로
            if(allBlack) {
                System.out.println(Math.min(H, W));
                continue;
            }
            
            int cnt = 0;
            
            // 행이 전부 검정색인지 확인
            for(int i = 0; i < H; i++) {
                boolean black = true;
                for(int j = 0; j < W; j++) {
                    if(arr[i][j] == '.') {
                        black = false;
                        break;
                    }
                }
                if(black) cnt++;
            }
            
            // 열이 전부 검정색인지 확인
            for(int j = 0; j < W; j++) {
                boolean black = true;
                for(int i = 0; i < H; i++) {
                    if(arr[i][j] == '.') {
                        black = false;
                        break;
                    }
                }
                if(black) cnt++;
            }
       	 	
            System.out.println(cnt);         
        }
    }
}