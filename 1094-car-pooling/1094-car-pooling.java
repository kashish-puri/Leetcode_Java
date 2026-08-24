class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int i = 0; i < trips.length; i++){
            int passenger = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            diff[from] += passenger;
            diff[to] -= passenger;
        }
        int curr = 0;
        for(int i = 0; i <= 1000; i++){
            curr += diff[i];
            if(curr > capacity) return false;
        }
        return true;
    }
}