import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        //각 경로에서의 최대 값 저장
        int dp[][] = new int[len][len];
    
        dp[0][0] = triangle[0][0];
        
        //왼쪽으로만 쭉 내려갔을 때
        for(int i =1; i<len; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }
        
        //나머지 경우
        for(int i =1; i<len; i++){
            for(int j=1; j<triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        int answer = 0;
        //배열 맨 하단에서 최대값 구하기
        for(int i =0; i<len; i++){
            answer = Math.max(answer, dp[len-1][i]);
        }
        
        return answer;
    }
}