class Solution {
    public int jump(int[] nums) {
        int maxR = 0;
        int currR = 0;
        int jump = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxR = Math.max(maxR, i + nums[i]);
            if(i == currR){
                jump++;
                currR = maxR;
            }
        }
        return jump;
    }
}