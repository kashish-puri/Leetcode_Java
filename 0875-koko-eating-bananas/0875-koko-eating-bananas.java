class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(canFinish(piles, mid, h)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean canFinish(int[] piles, int speed, int h){
        long hours = 0;
        for(int i = 0; i < piles.length; i++){
            hours += (piles[i] + speed - 1)/speed;
        }
        if(hours <= h) return true;
        else return false;
        
    }
    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int pile: piles){
            max = Math.max(max, pile);
        }
        return max;
    }
}