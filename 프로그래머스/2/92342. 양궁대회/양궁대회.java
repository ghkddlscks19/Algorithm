class Solution {
    //최대 점수
    static int max = 0;
    //라이언, 어피치, 정답 배열
    static int apeach[], ryan[], answer[];
    
    //인덱스, 현재 쏜 화살 개수, 총 화살 개수
    static void dfs(int idx, int shot, int n){
        //다 쐈을 때 점수 계산
        if(shot == n){
            int aScore = 0;
            int rScore = 0;
            for(int i =0; i<11; i++){
                //둘 다 0인 경우는 continue
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                //라이언이 더 많이 맞췄을 때
                if(apeach[i] < ryan[i]) rScore += 10-i;
                else aScore += 10-i;
            }
            
            //점수 차
            int gap = rScore - aScore;
            
            //라이언 점수가 더 클 때
            if(gap > 0){
                //최대 점수보다 점수 차가 클 때
                if(max < gap){
                    max = gap;
                    answer = ryan.clone();
                }else if(max == gap){ // 같을 때는 가장 낮은 점수를 많이 맞힌 경우 찾기 
                    for(int i =10; i>=0; i--){
                        if(answer[i] < ryan[i]){
                            answer = ryan.clone();
                        }else if(answer[i] > ryan[i]) return;
                    }
                }
            }
            return;
        }
        for(int i = idx; i<11; i++){
            if(ryan[i] > apeach[i]) continue;
            ryan[i]++;
            dfs(i, shot+1, n);
            ryan[i]--;
        }
    }
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        ryan = new int[11];
        answer = new int[11];
        dfs(0,0,n);
        
        int cnt = 0;
        for(int i =0; i<11; i++){
            if(answer[i] == 0){
                cnt++;
            }
        }
        if(cnt == 11) return new int[]{-1};
        return answer;
    }
}