import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        if(N == 1 || M == 1) bw.write(0 + "");
        else bw.write(2 * (N - 1) * (M - 1) + "");
        
        bw.flush();
        bw.close();
        
 
    }
   
}