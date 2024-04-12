class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = (long)times[0];
        long end = times[times.length-1] * (long)n;    
        
        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;
            for(int time : times){
                sum += mid/time;
            }
            
            if(sum >= n){
                end = mid - 1;
                answer = mid;
            }else{
                start = mid + 1;
            }
        }
        return answer;
    }
}