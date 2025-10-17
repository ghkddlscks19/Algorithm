import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(citations);
        
        // 반복문 순회 -> 
        int n = citations.length;
        for(int i =0; i<n; i++) {
            int h = n - i;
            
            if(h <= citations[i]) return h;
        }
        
        return answer;
    }
}