import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        //정해진 크기가 없으므로 ArrayList 선언
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i =0; i<arr.length; i++){
            //나머지가 0 일 때 추가
            if(arr[i] % divisor == 0) answer.add(arr[i]);    
        }
    
        //나누어 떨어지는 값이 하나도 없을 때 -1 추가
        if(answer.size() == 0) answer.add(-1);
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}