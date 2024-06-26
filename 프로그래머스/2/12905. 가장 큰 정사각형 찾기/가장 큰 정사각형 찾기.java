class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int col = board[0].length;
        int max = 0;
        
        if(row<=1 || col<=1){
            return 1;
        }
        
        for(int i =1; i<row; i++){
            for(int j =1; j<col; j++){
                if(board[i][j] == 1){
                    int leftUp = board[i-1][j-1];
                    int left = board[i][j-1];
                    int up = board[i-1][j];
                    board[i][j] = Math.min(leftUp, Math.min(left, up))+1;
                    max = Math.max(max, board[i][j]); 
                }
            }
        }     
        
        return max*max;
    }
}