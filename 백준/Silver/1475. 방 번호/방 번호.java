import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        //나온 숫자 체크
        int arr[] = new int[10];

        int set = 0;

        //6과 9는 뒤집어서 사용가능 -> 어케 처리할까
        for(int i =0; i<N.length(); i++) {
            arr[N.charAt(i)-'0']++;
        }

        int sixNine = (arr[6] + arr[9] + 1) / 2;
        arr[6] = sixNine;
        arr[9] = sixNine;
        
        for(int i =0; i<10; i++) {
            set = Math.max(set, arr[i]);
        }
        
        System.out.println(set);
    }
}