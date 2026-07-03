class Solution {
    public int maxProduct(int[] nums) {
        int maxP = Integer.MIN_VALUE;
        int prod = 1;
        for(int i = 0; i < nums.length; i++){
            prod *= nums[i];
            maxP = Math.max(maxP, prod);
            if(prod == 0) prod = 1;
        }
        prod = 1;
        for(int j = nums.length-1; j >= 0; j--){
            prod *= nums[j];
            maxP = Math.max(maxP, prod);
            if(prod == 0) prod = 1;
        }  
        return maxP;
    }
}