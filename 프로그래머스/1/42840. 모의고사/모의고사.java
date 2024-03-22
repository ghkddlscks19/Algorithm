import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
            
        int st1Cnt = 0;
        int st2Cnt = 0;
        int st3Cnt = 0;
        
        //답 개수 반복문
        for(int i =0; i<answers.length; i++){
            //1,2,3번의 학생의 풀이와 답이 같은지 판별
            if(answers[i] == st1[i%st1.length]) st1Cnt++;
            if(answers[i] == st2[i%st2.length]) st2Cnt++;
            if(answers[i] == st3[i%st3.length]) st3Cnt++;
        }
        
        if(st1Cnt>=st2Cnt && st1Cnt>=st3Cnt) answer.add(1);
        if(st2Cnt>=st1Cnt && st2Cnt>=st3Cnt) answer.add(2);
        if(st3Cnt>=st1Cnt && st3Cnt>=st2Cnt) answer.add(3);
        
        

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}