import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i =0; i<N; i++) {
            String input = br.readLine();
            if (isValid(input)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isValid(String input) {
        boolean alphabet[] = new boolean[26];
        int record = 0;

        for(int i = 0; i<input.length(); i++) {
            int now = input.charAt(i);

            if(record != now) {
                if(!alphabet[now - 'a']) {
                    alphabet[now - 'a'] = true;
                    record = now;
                }else {
                    return false;
                }
            }
        }

        return true;
    }
}