class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //행 길이
        int r1 = arr1.length;
        int r2 = arr2.length;
        
        //열 길이
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;
        
        int[][] answer = new int[r1][c2];
        
        //반복문
        for(int i =0; i<r1; i++){
            for(int j =0; j<c2; j++){
                for(int k=0; k<c1; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}