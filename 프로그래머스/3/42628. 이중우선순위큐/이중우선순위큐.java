import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for(String operation: operations) {
            String[] split = operation.split(" ");
            String op = split[0];
            int num = Integer.parseInt(split[1]);
            
            // 삽입
            if(op.equals("I")) {
                tm.put(num, tm.getOrDefault(num, 0) + 1);
            } else {
                // 비어있으면 삭제 연산 무시
                if(tm.isEmpty()) continue;
                
                // 최솟값, 최댓값 삭제
                if(num == -1) {
                    int minKey = tm.firstKey();
                    if(tm.get(minKey) == 1) tm.remove(minKey);
                    else tm.put(minKey, tm.get(minKey) - 1);
                } else { 
                    int maxKey = tm.lastKey();
                    if(tm.get(maxKey) == 1) tm.remove(maxKey);
                    else tm.put(maxKey, tm.get(maxKey) - 1);
                }
            }
            
        }
        
        if(tm.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{tm.lastKey(), tm.firstKey()};
    }
}