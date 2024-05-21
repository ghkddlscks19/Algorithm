class Solution {
    public int[] solution(String s) {
        //이진 변환 횟수
        int transCnt = 0;
        //제거한 모든 0의 갯수
        int zeroCnt = 0;
        
        while(!s.equals("1")){
            transCnt++; //이진 변환이 진행되는 과정이므로 증가
            int zero = s.replace("1", "").length(); //1을 다 제거해 0의 갯수 반환
            zeroCnt+=zero;
            s = Integer.toBinaryString(s.length()-zero);
        }
        
        return new int[]{transCnt, zeroCnt};
    }
}