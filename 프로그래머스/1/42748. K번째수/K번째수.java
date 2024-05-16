import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //커맨드 크기만큼 돌면서 배열을 자르기
        for(int n =0; n<commands.length; n++){
            int i = commands[n][0]-1;
            int j = commands[n][1];
            int k = commands[n][2]-1;
            //복사할배열, 시작점, 끝점 -> 인덱스 0을 기준으로 함
            int copy[] = Arrays.copyOfRange(array, i, j);
            //나온 배열을 정렬하기
            Arrays.sort(copy);
            //k번 째 숫자를 정답 배열에 넣기
            answer[n] = copy[k];
        }
        return answer;
    }
}