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

        //일단 다 넣고 나중에 2로 나누자
        //반올림 해야되니까 1 더하자
        int sixNine = (arr[6] + arr[9] + 1) / 2;
        arr[6] = sixNine;
        arr[9] = sixNine;

        for(int i =0; i<10; i++) {
            set = Math.max(set, arr[i]);
        }

        System.out.println(set);
    }
}