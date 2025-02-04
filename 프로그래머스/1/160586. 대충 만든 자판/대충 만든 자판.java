import java.util.*;
class Solution {
    // 10^3 -> 2중 for 가능
    public int[] solution(String[] keymap, String[] targets) {      
        // 알파벳과 최소 횟수 저장할 해시맵
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i =0; i<keymap.length; i++) {
            for(int j =0; j<keymap[i].length(); j++) {
                // 이미 해시맵에 저장되어 있을 때
                if(hm.containsKey(keymap[i].charAt(j))) {
                    int curr = hm.get(keymap[i].charAt(j));
                    if(curr > j+1) { // 현재 저장된 횟수가 더 크면 교체
                        hm.put(keymap[i].charAt(j), j+1);
                    }
                } else {
                    hm.put(keymap[i].charAt(j), j+1);
                }
            }
        }
        
        int answer[] = new int[targets.length];
        
        // 목표 문자열 확인
        for(int i =0; i<targets.length; i++) {
            for(int j =0; j<targets[i].length(); j++) {
                // 포함 되어 있으면 찾아서 더해주기
                if(hm.containsKey(targets[i].charAt(j))) { 
                    answer[i] += hm.get(targets[i].charAt(j));
                } else { // 포함 되어 있지 않으면 -1
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}