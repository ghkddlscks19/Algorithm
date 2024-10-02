import java.io.*;
import java.util.*;
class Main {
	static int me = 0, fr = 0;
	public static void main(String[] args) throws Exception {
		//진행 횟수 T
		//사탕 갯수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v[] = new int[T];
		for(int i =0; i<T; i++){
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =0; i<T; i++){
			if(v[i] % 2== 0) fr++;
			else me++;
		}
		
		if(fr == me){
			System.out.println("tie");
		}else if(fr > me){
			System.out.println(fr);
		}else{
			System.out.println(me);
		}
	}
}