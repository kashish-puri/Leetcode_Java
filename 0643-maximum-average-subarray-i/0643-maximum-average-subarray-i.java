class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int n=nums.length;
        int max=sum;
        for(int j=k;j<n;j++){
            sum=sum+nums[j]-nums[j-k];
            max=Math.max(sum,max);
        }
        return (double)max/k;
    }
}