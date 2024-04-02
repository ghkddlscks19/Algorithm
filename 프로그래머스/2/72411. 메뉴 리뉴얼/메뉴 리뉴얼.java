import java.util.*;
class Solution {
    
    static HashMap<String, Integer> courseMap = new HashMap<>();
    
    public static void combi(int n, char c[], String result){
        if(result.length() > 1){
            char sortArray[] = result.toCharArray();
            Arrays.sort(sortArray);
            String sortStr = String.valueOf(sortArray);
            courseMap.put(sortStr, courseMap.getOrDefault(sortStr, 0) + 1);
        }
        for(int i =n; i<c.length; i++){
            combi(i+1, c, result+c[i]);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(String s : orders){
            char[] ordersArray = s.toCharArray();
            combi(0, ordersArray, "");
        }
        
        for(int x : course){
            int max = 0;
            for(String s : courseMap.keySet()){
                if(s.length() == x && courseMap.get(s) >= 2){
                    max = Math.max(max, courseMap.get(s));
                }
            }
            for(String s : courseMap.keySet()){
                if(s.length() == x && courseMap.get(s) == max){
                    answer.add(s);
                }
            }
        }
        
        Collections.sort(answer);
        
    
        
        return answer.toArray(new String[answer.size()]);
    }
    
    
    
}