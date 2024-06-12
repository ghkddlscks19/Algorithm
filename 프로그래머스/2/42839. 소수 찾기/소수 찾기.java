import java.util.*;
class Solution {
    
    static boolean visited[];
    static HashSet<Integer> hs;
    static int answer = 0;
    //각 숫자들을 하나씩 뽑아 모든 숫자 경우의 수 만들기
    static void dfs(String numbers, String curr, int depth){
        if(depth == numbers.length()) return;
        
        for(int i =0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                hs.add(Integer.parseInt(curr + numbers.charAt(i)));
                dfs(numbers, curr + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    
    static void isPrime(HashSet<Integer> hs){
        //set을 arrayList로 변환
        ArrayList<Integer> numList = new ArrayList<>(hs);
        //최대값 추출
        int max = Collections.max(numList);
        System.out.println(max);
        boolean prime[] = new boolean[max+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        //최대값까지 소수 판별해놓기
        for(int i =2; i<=Math.sqrt(max); i++){
            if(prime[i]){
                for(int j = i*i; j<=max; j+=i) {
			       prime[j] = false;
        	    }
            } 
        }
        
        for(int n : numList){
            //소수일 때 정답 증가
            if(prime[n] == true) answer++;
        }
    }
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        hs = new HashSet<>();
        dfs(numbers, "", 0);
        System.out.println(hs);
        isPrime(hs);
        return answer;
    }
}