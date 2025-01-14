class Solution {
    public int[] solution(String[] wallpaper) {
        // 빈칸은 . / 파일이 있는 칸 #
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
            
        char c[][] = new char[row][col];
        // 2차원 배열로 변경
        for(int i =0; i<row; i++) {
            for(int j =0; j<col; j++) {
                c[i][j] = wallpaper[i].charAt(j);
                
                // #일 때 최소, 최대 좌표 구하기
                if(c[i][j] == '#') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        int[] answer = {minX, minY, maxX+1, maxY+1};
        return answer;
    }
}