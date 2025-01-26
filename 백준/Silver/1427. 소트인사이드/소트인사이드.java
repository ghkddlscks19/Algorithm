import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[10];
		int i = 0;
		if(N>0 && N<10) {
			System.out.println(N);
		}else {
			while(true) {
				arr[i] = N%10;
				N = N/10;
				i++;
			
				if(N/10 == 0) {
					arr[i] = N%10;
					i++;
					break;
				}
			}
			Arrays.sort(arr);
		
			for(int j=9; i>0; j--,i--) {
				System.out.print(arr[j]);
			}
		}
	}

}