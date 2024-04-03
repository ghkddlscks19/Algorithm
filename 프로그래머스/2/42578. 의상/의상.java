import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for(int i =0; i<clothes.length; i++){
            String category = clothes[i][1];
            clothesMap.put(category, clothesMap.getOrDefault(category, 0) + 1);
        }
        
        for(String key : clothesMap.keySet()){
            answer *= (clothesMap.get(key)+1);
        }
        
        answer--;
        
        return answer;
    }
}