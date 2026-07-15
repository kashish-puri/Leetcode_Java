class Solution {
    public int minn(int[] bloomDay){
        int min = Integer.MAX_VALUE;
        for(int bloom: bloomDay){
            min = Math.min(min, bloom);
        }
        return min;
    }
    public int maxx(int[] bloomDay){
        int max = Integer.MIN_VALUE;
        for(int bloom: bloomDay){
            max = Math.max(max, bloom);
        }
        return max;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;
        int low = minn(bloomDay);
        int high = maxx(bloomDay);
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canMake(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay, int day, int m, int k){
        int flowers = 0, bouquets = 0;
        for(int bloom : bloomDay){
            if(bloom <= day) flowers++;
            else flowers = 0;
            if(flowers == k){
                bouquets++;
                flowers = 0;
            }
        }
        if(bouquets >= m) return true;
        else return false; 
    }
}