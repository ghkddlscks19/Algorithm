import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sub = sc.nextInt();
		int[] array = new int[sub];
		double avg = 0;
		int max = 0;
		
		for(int i=0; i<array.length; i++) {
			array[i] = sc.nextInt();
			if(max<array[i]) {
				max = array[i];
			}

		}
		for(int i=0; i<array.length; i++) {
			avg += (double)array[i]/max*100;
		}
		System.out.println(avg/array.length);

	}

}