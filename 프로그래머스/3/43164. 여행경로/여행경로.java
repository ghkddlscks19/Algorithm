import java.util.*;
class Solution {
    
    //티켓 사용 여부
    static boolean useTicket[];
    
    //최종 경로를 저장할 공간
    static ArrayList<String> result;
    
    static void dfs(String tickets[][], String start, String path, int depth){
        if(depth == tickets.length){
            //갈 수 있는 모든 경로 저장
            result.add(path);
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            //현재 티켓의 출발점과 시작점이 같고 티켓을 사용 안했을 때
            if(tickets[i][0].equals(start) && !useTicket[i]){
                //방문처리
                useTicket[i] = true;
                //현재 티켓의 도착점을 시작점으로 재설정 및 경로에 현재 티켓의 도착점 추가
                dfs(tickets, tickets[i][1], path+" "+tickets[i][1], depth+1);
                useTicket[i] = false;
            }
        }  
    }
    
    public String[] solution(String[][] tickets) {        
        useTicket = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs(tickets, "ICN", "ICN", 0);
  
        //갈 수 있는 경로들을 정렬
        Collections.sort(result);
        
        //가장 알파벳이 앞서는 경로를 answer 배열에 저장
        String[] answer = result.get(0).split(" ");
        return answer;
    }
}