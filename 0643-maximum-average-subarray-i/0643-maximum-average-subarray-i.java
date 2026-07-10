class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int n = nums.length;
        int max = sum;
        for(int i = k; i < n; i++){
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }
        return (double)max/k;
    }
}