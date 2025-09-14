import java.util.*;
class Solution {
    public String solution(String s) {
        String parts[] = s.split(" ");
        
        int arr[] = new int[parts.length];
        for(int i =0; i<parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        Arrays.sort(arr);
        
        String answer = arr[0] + " " + arr[parts.length - 1];
        return answer;
    }
}