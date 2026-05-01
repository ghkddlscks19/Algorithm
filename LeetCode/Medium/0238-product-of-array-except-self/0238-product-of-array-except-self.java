class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        // 현재 기준 왼쪽 곱 저장
        for(int i =1; i<n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        // 오른쪽 누적 곱은 변수로 해결힌다.
        // left랑 변수를 곱하고 변수는 현재값을 곱해서 갱신한다.
        int r = 1;
        int[] answer = new int[n];
        for(int i =n-1; i>=0; i--) {
            answer[i] = left[i] * r;
            r *= nums[i];
        }

        return answer;
    }
}
