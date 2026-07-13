class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = findmax(weights);
        int sum = 0;
        for(int weight : weights){
            sum += weight;
        }
        int high = sum;
        int ans = Integer.MIN_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canShip(weights, mid, days)){
                ans = mid;
                high = mid - 1; 
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean canShip(int[] weights, int capacity, int days){
        int daysUsed = 1;
        int curr = 0;
        for(int weight : weights){
            if(curr + weight <= capacity){
                curr += weight;
            }
            else{
                curr = weight;
                daysUsed++;
            }
        } 
        return daysUsed <= days;
    }
    public int findmax(int[] weights){
        int max = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
        }
        return max;
    }
}