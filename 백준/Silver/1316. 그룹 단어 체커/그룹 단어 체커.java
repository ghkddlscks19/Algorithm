import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int count = 0;
		int n = sc.nextInt();
		for(int i =0; i<n; i++) {
			if(Ischeck() == true) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static boolean Ischeck() {
		boolean check[] = new boolean[26];
		int pr = 0;
		String s = sc.next();
		
		for(int i=0; i<s.length();i++) {
			int now = s.charAt(i);
			
			if(pr!=now) {
				
				if(check[now-'a'] == false) {
					check[now-'a'] = true;
					pr = now;
				}else {
					return false;
				}
			}
			else {
				continue;
			}
		}
			
		return true;
	}
	
	
}