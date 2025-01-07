import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        // S: 시작지점, O: 지나갈 수 있음, X: 장애물 
        // 못간다? 명령 무시
        
        int h = park.length;
        int w = park[0].length();
        
        // park 정보를 담을 2차원 배열
        char c[][] = new char[h][w]; 
        
        // 이동 배열
        int dh[] = {-1, 0, 1, 0};
        int dw[] = {0, 1, 0, -1};
        
        // dh, dw를 해시맵에 방향이랑 인덱스 묶어서 저장
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('N', 0);
        hm.put('E', 1);
        hm.put('S', 2);
        hm.put('W', 3);
        
        int answer[] = new int[2];
        
        // 시작 위치 구하기 및 2차원 배열 변환
        for(int i =0; i<h; i++) {
            c[i] = park[i].toCharArray();
            
            if(park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
            }
        }
        
        // 루트만큼 이동하면서 순회
        for(String route : routes) {
            // 방향 및 거리
            char dir = route.charAt(0);            
            int dist = route.charAt(2) - '0';
            
            int nh = answer[0];
            int nw = answer[1];
            int index = hm.get(dir);
            
            boolean isPossible = true;
            
            for(int i =0; i<dist; i++) {
                int nextH = nh + dh[index];
                int nextW = nw + dw[index];
                // 경계 체크 및 장애물 확인
                if (nextH < 0 || nextW < 0 || nextH >= h || nextW >= w || c[nextH][nextW] == 'X') {
                    isPossible = false;
                    break; // 이동 불가
                }
                
                nh = nextH;
                nw = nextW;
            }
            if(isPossible) {
                answer[0] = nh;
                answer[1] = nw;
            }
         }
        
        return answer;
    }
}