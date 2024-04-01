import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        //(장르, 총 재생 수)
        HashMap<String, Integer> genreMap = new HashMap<>();
        //(장르, (고유번호, 재생 수))
        HashMap<String, HashMap<Integer, Integer>> musicMap = new HashMap<>();
        
        for(int i =0; i<plays.length; i++){
            if(!genreMap.containsKey(genres[i])){
                //(고유번호, 재생 수)
                HashMap<Integer, Integer> music = new HashMap<>();
                genreMap.put(genres[i], plays[i]);
                music.put(i,plays[i]);
                musicMap.put(genres[i], music);
                
            }else{
                genreMap.put(genres[i], genreMap.get(genres[i])+plays[i]);
                musicMap.get(genres[i]).put(i,plays[i]);
            }
        }
        
        //genreMap에 있는 key를 재생 수 기준으로 내림차순 정렬
        List<String> genre_key = new ArrayList<>(genreMap.keySet());
        Collections.sort(genre_key, (s1,s2) -> genreMap.get(s2) - genreMap.get(s1));
        
        //genre_key에서 재생 수 내림차순으로 2개의 노래 선택
        for(String key : genre_key){
            //genre_key에 해당하는 (고유번호, 재생 수)
            HashMap<Integer, Integer> music = new HashMap<>(musicMap.get(key));
            //노래 고유번호 추출
            List<Integer> music_num = new ArrayList(music.keySet());
            //재생 수로 내림차순
            Collections.sort(music_num, (s1,s2) -> music.get(s2) - music.get(s1));
            
            answer.add(music_num.get(0));
            
            if(music_num.size() > 1){
                answer.add(music_num.get(1));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}