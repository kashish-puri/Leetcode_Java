class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] pref = new int[n + 1];
        pref[0] = 0;
        for(int i = 1; i < n + 1; i++){
            pref[i] = pref[i - 1] + gain[i - 1];
        }
        int max = pref[0];
        for(int i = 1; i <= n; i++){
            max = Math.max(max, pref[i]);
        }
        return max;
    }
}