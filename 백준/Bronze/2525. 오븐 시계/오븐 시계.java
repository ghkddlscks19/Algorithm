import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int hour = Integer.parseInt(st.nextToken()) * 60; //분 단위로 변환
        int min = Integer.parseInt(st.nextToken());
        int cook = Integer.parseInt(br.readLine());

        int result = hour + min + cook;

        System.out.println(result / 60 % 24 + " " + result % 60);
    }
}