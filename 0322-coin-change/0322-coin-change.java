class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = f(n - 1, amount, coins, dp);
        return ans >= 1000000000 ? -1 : ans;
    }
    public int f(int idx, int amt, int[] coins, int[][] dp){
        if(amt == 0) return 0;
        if(idx == 0){
            if(amt % coins[idx] == 0){
                return amt/coins[idx];
            }
            return 1000000000;
        }
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int notTake = f(idx - 1, amt, coins, dp);
        int take = 1000000000;
        if(coins[idx] <= amt){
            take = 1 + f(idx, amt - coins[idx], coins, dp);
        }
        return dp[idx][amt] = Math.min(take, notTake);
    }
}