class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            
            // sum이 k보다 크면 lt를 오른쪽으로 이동시켜 sum을 줄임
            while (sum > k) {
                sum -= sequence[lt];
                lt++;
            }
             
            if (sum == k) {
                if(min > rt-lt){
                    min = rt-lt;
                    answer[0] = lt;
                    answer[1] = rt;
                }
                
            }
        }
        return answer;
    }
}