class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd=nums[0];
        for(int i=1; i<nums.length;i++){
            gcd=findGcd(gcd, nums[i]);
        }
        return gcd==1;

    }
    public int findGcd(int a, int b){
        if(b==0) return a;
        return findGcd(b,a%b);
    }
}