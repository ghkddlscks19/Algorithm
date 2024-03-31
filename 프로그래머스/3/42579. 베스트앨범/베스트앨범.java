import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> musicMap = new HashMap<>();
        
        for(int i =0; i<plays.length; i++){
            if(!genreMap.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                genreMap.put(genres[i], plays[i]);
                map.put(i, plays[i]);
                musicMap.put(genres[i], map);
            }else{
                genreMap.put(genres[i], genreMap.get(genres[i])+plays[i]);
                musicMap.get(genres[i]).put(i,plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList<>(genreMap.keySet());
        Collections.sort(keySet, (s1,s2) -> genreMap.get(s2) - genreMap.get(s1));
        
        for(String s : keySet){
            HashMap<Integer, Integer> hm = musicMap.get(s);
            List<Integer> key = new ArrayList<>(hm.keySet());
            Collections.sort(key, (s1,s2) -> hm.get(s2) - hm.get(s1));
            
            answer.add(key.get(0));
            if(key.size()>1){
                answer.add(key.get(1));
            }
        }
        
    
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}