import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int i = 1; i <= T; i++)
		{
        	int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
            	if(num % 2 != 0) sum += num;
            }
            
            bw.write("#" + i + " "+ sum + "\n");       
        }
        bw.flush();
        bw.close();
	}
}