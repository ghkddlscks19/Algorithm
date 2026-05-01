class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for(int i =0; i<len; i++) {
            if(nums[i] <= first) first = nums[i];
            else if(nums[i] <= second) second = nums[i];
            if(first < nums[i] && second < nums[i]) return true;
        }
    
        return false;
    }
}