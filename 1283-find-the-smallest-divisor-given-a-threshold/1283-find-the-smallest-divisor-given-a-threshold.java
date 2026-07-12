class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(nums, mid, threshold)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public boolean isValid(int[] nums, int divisor, int threshold){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] + divisor - 1)/divisor;
        }
        if(sum <= threshold) return true;
        else return false;
    }
    public int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }
}