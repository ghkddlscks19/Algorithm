import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toUpperCase();

        int arr[] = new int[26];
        int max = 0;
        int cnt = 0;
        String result = "";

        for(int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'A']++;
            max = Math.max(max, arr[input.charAt(i) - 'A']);
        }

        for(int i = 0; i < 26; i++) {
            if(arr[i] == max) {
                cnt++;
                result = String.valueOf((char) (i+65));
            }
            if(cnt > 1) {
                result = "?";
                break;
            }
        }
        System.out.println(result);
    }
}