import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int length = input.length();
        int result = 1;

        for(int i = length -1; i >= 0; i--) { //4 0 3 1 2 2
            if(input.charAt(i) != input.charAt(length - i - 1)) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}