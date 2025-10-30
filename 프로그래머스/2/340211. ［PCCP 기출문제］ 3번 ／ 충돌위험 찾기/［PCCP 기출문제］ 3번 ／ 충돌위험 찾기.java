import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // 모든 경로를 구하기
        List<List<Point>> pathList = new ArrayList<>();
        
        for(int[] route: routes) {
            List<Point> list = new ArrayList<>();
            
            // 시작 지점
            int[] start = points[route[0] - 1];
            list.add(new Point(start[0], start[1]));
            
            for(int i =1; i<route.length; i++) {
                int[] from = points[route[i-1] - 1];
                int[] to = points[route[i] - 1];
                
                int r = from[0];
                int c = from[1];
                
                // from -> to로 이동
                while(r != to[0]) {
                    if(r < to[0]) r += 1;
                    else r -= 1;
                    list.add(new Point(r, c));
                }
                
                while(c != to[1]) {
                    if(c < to[1]) c += 1;
                    else c -= 1;
                    list.add(new Point(r, c));
                }      
                
            }
            
            pathList.add(list);
        }
        
        // 최대 시간만큼 루프를 돌아야함
        int maxTime = 0;
        for (List<Point> path : pathList) {
            maxTime = Math.max(maxTime, path.size());
        }
        
        // 시간 별로 hashmap에 넣어서 겹치는거 확인하기
        for(int i =0; i<maxTime; i++) {
            HashMap<String, Integer> hm = new HashMap<>();
            
            for(List<Point> path: pathList) {
               if(i < path.size()) {
                   String key = i + " " + path.get(i).x + " " + path.get(i).y;
                   hm.put(key, hm.getOrDefault(key, 0) + 1);
               }
            }
            
            // 해시맵에 2 이상 쌓였으면 answer 추가
            for(int count: hm.values()) {
                if(count >= 2) answer++;
            }
        }        
        
        return answer;
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}