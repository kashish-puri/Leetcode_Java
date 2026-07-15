class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canSplit(nums, mid, k)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public boolean canSplit(int[] nums, int limit, int k){
        int count = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num <= limit){
                sum += num;
            }
            else{
                sum = num;
                count++;
            }
        }
        return count <= k;
    }
}