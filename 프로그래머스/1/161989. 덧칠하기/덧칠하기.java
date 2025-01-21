class Solution {
    public int solution(int n, int m, int[] section) {
        // n은 전체 영역, m은 내가 칠할 수 있는 영역 크기, section은 비어 있는 곳
        int answer = 0; 
        int painted = 0; 
        
        for (int location : section) {
            if (location > painted) {
                answer++; 
                painted = location + m - 1; 
            }
        }
        
        return answer;
    }
}