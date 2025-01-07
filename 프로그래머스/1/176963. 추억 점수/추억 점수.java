import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 이름, 그리움 점수 다른 사진 속 인물
        // name 길이 == yearning 길이
        // 없는 사람은 합산하지 않음
        
        // 저장 할 hashmap 초기화
        HashMap<String, Integer> hm = new HashMap<>();
        
        // name 만큼 돌면서 이름과 그리움 점수 hashmap에 추가
        for(int i =0; i<name.length; i++) {
            hm.put(name[i], yearning[i]);
        }
        
        int answer[] = new int[photo.length];
        int sum = 0;
        
        // photo 돌면서 점수 합산
        for(int i =0; i<photo.length; i++) {
            for(int j =0; j<photo[i].length; j++) {
                sum += hm.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
            sum = 0;
        }
        
       return answer;
    }
}