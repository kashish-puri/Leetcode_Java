class Solution {
    public int maxSubArray(int[] nums) {
        int maxs=nums[0],currs=nums[0];
        for(int i=1;i<nums.length;i++){
            currs=Math.max(nums[i],currs+nums[i]);
            maxs=Math.max(maxs,currs);
        }
        return maxs;
    }
}