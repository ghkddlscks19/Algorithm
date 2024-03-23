import java.util.*;
class Solution {
    //다음 좌표를 저장하기 위한 HashMap
    static HashMap<Character, int[]> location = new HashMap<>();
    //범위를 벗어나지 않는지 확인
    public static boolean isValid(int nx, int ny){
        if(nx>=0 && nx<11 && ny>=0 && ny<11) return true;
        return false;
    }
    //4가지 방향 설정
    public static void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});       
    }
    public int solution(String dirs) {
        initLocation();
        //시작 위치를 (5,5)로 설정
        int x = 5;
        int y = 5;
        //중복 제거를 위해 사용
        HashSet<String> hs = new HashSet<>();
        for(int i =0; i < dirs.length(); i++){
            int dis[] = location.get(dirs.charAt(i));
            int nx = x+dis[0];
            int ny = y+dis[1];
            if(!isValid(nx, ny)) continue;
            
            //총 경로의 개수는 방향성이 없어서 양방향 모두 넣어줘야 함.
            hs.add(x + " " + y + " " + nx + " " + ny);
            hs.add(nx + " " + ny + " " + x + " "+ y);
            
            x = nx;
            y = ny;
        }
        //양방향으로 넣었으니까 2로 나눠줘야 함.
        return hs.size()/2;
    }
}