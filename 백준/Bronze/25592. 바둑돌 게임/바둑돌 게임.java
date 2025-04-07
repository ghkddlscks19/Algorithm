import java.util.*;
import java.io.*;

public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int turn = 1;

    boolean isMe = true;

    while(N >= turn) {
      N -= turn;
      isMe = !isMe;
      turn++;
    }

    if(isMe) bw.write(turn - N + "");
    else bw.write(0 + "");

    bw.flush();
    bw.close();
  }
}
