import java.util.*;
class Solution {
    //모음 사전을 저장할 리스트
    static ArrayList<String> dict;
    //모음 넣어놓을 배열
    static String vowels[];
    
    static void dfs(String vowels[], String curr, int depth){
        dict.add(curr);
        if(depth == 5){
            return;
        }
        for(int i =0; i<5; i++){
            dfs(vowels, curr+vowels[i], depth+1);
        }
    }
    public int solution(String word) {
        vowels = new String[]{"A","E","I","O","U"};
        dict = new ArrayList<>();
        int answer = 0;
        dfs(vowels, "", 0); 
        for(int i =0; i<dict.size(); i++){
            if(dict.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}