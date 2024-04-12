import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        //끝말잇기는 중복 제거가 필요함
        HashSet<String> wordSet = new HashSet<>();
        //끝말잇기 시작 알파벳
        char start = words[0].charAt(0);
        
        for(int i =0; i<words.length; i++){
            //사람의 인덱스
            int person = i % n + 1;
            //몇 번째 순서
            int order = i / n + 1;
            System.out.println(person + " " + order);
            
            //중복이거나 끝말잇기 시작 알파벳이 잘못 되었을 때
            if(wordSet.contains(words[i]) || words[i].charAt(0) != start){
                answer[0] = person;
                answer[1] = order;
                break;
            }else{
                wordSet.add(words[i]);
                start = words[i].charAt(words[i].length()-1);
            }
        }
       return answer;
    }
}