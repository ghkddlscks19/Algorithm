import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str;
    
    while(true) {
      str = br.readLine();

      if(str.equals(".")) break;
      ArrayDeque<Character> stack = new ArrayDeque<>();
      boolean isBalanced = true;
      
      for(int i =0; i<str.length(); i++) {
        char c = str.charAt(i);
        
        if(c == '(' || c == '[') stack.push(c);
        else if(c == ')') {
          if(stack.isEmpty() || stack.peek() != '(') {
            isBalanced = false;
            break;
          } else stack.pop();
        } 
        else if(c == ']') {
          if(stack.isEmpty() || stack.peek() != '[') {
            isBalanced = false;
            break;
          } else stack.pop();
        }
      }
      if(stack.isEmpty() && isBalanced) {
        bw.write("yes");
      } else {
        bw.write("no");   
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
}