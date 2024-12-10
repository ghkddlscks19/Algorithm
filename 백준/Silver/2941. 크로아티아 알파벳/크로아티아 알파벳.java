import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int cnt = 0;

        for(int i =0; i < input.length(); i++){
            if(input.charAt(i) == 'c'){
                if(i < input.length() - 1) {
                    if(input.charAt(i+1) == '='){
                        i++;
                    } else if (input.charAt(i+1) == '-') {
                        i++;
                    }
                }
            } else if (input.charAt(i) == 'd') {
                if(i < input.length() - 1) {
                    if(input.charAt(i+1) == '-'){
                        i++;
                    } else if (input.charAt(i+1) == 'z') {
                        if(i <input.length() - 2) {
                            if(input.charAt(i+2) == '='){
                                i+=2;
                            }
                        }
                    }
                }
            } else if(input.charAt(i) == 'l'){
                if(i < input.length() - 1) {
                    if(input.charAt(i+1) == 'j'){
                        i++;
                    }
                }
            } else if(input.charAt(i) == 'n'){
                if(i < input.length() - 1) {
                    if(input.charAt(i+1) == 'j'){
                        i++;
                    }
                }
            } else if(input.charAt(i) == 's'){
                if(i < input.length() - 1) {
                    if(input.charAt(i+1) == '='){
                        i++;
                    }
                }
            } else if(input.charAt(i) == 'z'){
                if(i < input.length() - 1) {
                    if(input.charAt(i+1) == '='){
                        i++;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}