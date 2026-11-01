class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        for(int i = 0; i < nums.length; i++){
            right = total - nums[i] - left;
            if(left == right) return i;
            left += nums[i];
        }
        return -1;

    }
}