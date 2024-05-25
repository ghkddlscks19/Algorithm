class Solution {
    public int solution(String name) {
        int len = name.length();
        //기본 좌우 조작 횟수
        int move = len - 1;
        int answer = 0;
             
        for(int i =0; i<len; i++){
            //알파벳 변경에 대한 최솟값 구하기
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            //연속된 A의 개수 구하기
            int next = i+1;
            while(next<len && name.charAt(next) == 'A'){
                next++;
            }
            move = Math.min(move, (i*2)+len-next);
            move = Math.min(move, (len-next)*2+i);
        }
        
        return answer+move;
    }
}