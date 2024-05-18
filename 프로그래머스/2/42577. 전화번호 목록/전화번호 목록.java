import java.util.*;
class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         HashMap<String, Integer> phoneMap = new HashMap<>();
        
//         for(String phone : phone_book){
//             phoneMap.put(phone, phoneMap.getOrDefault(phone, 0) + 1);
//         }
        
//         for(String s : phoneMap.keySet()){
//             for(int i =1; i<s.length(); i++){
//                 String str = s.substring(0,i);
//                 if(phoneMap.containsKey(str)) return false;
//             }
            
//         }
//         return answer;
//     }
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i =0; i<phone_book.length -1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}