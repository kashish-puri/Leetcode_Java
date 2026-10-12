class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n - 1, dp, nums);
    }
    public int f(int idx, int[] dp, int[] nums){
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = nums[idx] + f(idx - 2, dp, nums);
        int nottake = 0 + f(idx - 1, dp, nums);
        dp[idx] = Math.max(take,nottake);
        return dp[idx];
    }
}