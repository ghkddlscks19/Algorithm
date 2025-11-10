class Solution {
    int[] discounts = {10, 20, 30, 40};
    int maxSubscriber = 0; // 최종 이모티콘 플러스 가입자 수
    int maxMoney = 0; // 최종 이모티콘 판매액
    public int[] solution(int[][] users, int[] emoticons) {
        int[] selectedDiscount = new int[emoticons.length]; // 최종 할인율 조합
        backtracking(0, selectedDiscount, users, emoticons);
        
        int[] answer = {maxSubscriber, maxMoney};
      
               
        return answer;
    }
    
    void backtracking(int idx, int[] selectedDiscount, int[][] users, int[] emoticons) {
        if(idx == emoticons.length) {
            calculate(selectedDiscount, users, emoticons);
            return;
        }
        
        // 10% 20% 30% 40% 경우의 수 만들기
        for(int discount: discounts) {
            selectedDiscount[idx] = discount;
            backtracking(idx + 1, selectedDiscount, users, emoticons);
        }
    
    }
    
    // 목표 1: 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
    // 목표 2: 이모티콘 판매액을 최대한 늘리는 것.
    void calculate(int[] selectedDiscount, int[][] users, int[] emoticons) {
        int subscriber = 0;
        int money = 0;
        
        // 가입자 확인
        for(int[] user: users) {
            int minDiscount = user[0];
            int limitPrice = user[1];
            int price = 0;
            
            for(int i =0; i<emoticons.length; i++) {
                // 최소 비율 이상이면 구매
                if (selectedDiscount[i] >= minDiscount) {
                    price += emoticons[i] * (100 - selectedDiscount[i]) / 100;
                }
            }
            
            // 제한 금액을 넘어서면 이모티콘 플러스 가입 아니면 금액에 추가
            if(limitPrice <= price) subscriber++;
            else money += price;
            
        }
        
        // 서비스 가입자가 최대면 갱신
        if(maxSubscriber < subscriber) {
            maxSubscriber = subscriber;
            maxMoney = money;
        } else if(maxSubscriber == subscriber) { // 서비스 가입자 수가 같을 때
            if(maxMoney <= money) maxMoney = money;
        }
        
    }
}