class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(n - 1, amount, coins, dp);
    }
    public int f(int idx, int amt, int[] coins, int[][] dp){
        if(amt == 0) return 1;
        if(idx == 0){
            if(amt % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int notTake = f(idx - 1, amt, coins, dp);
        int take = 0;
        if(coins[idx] <= amt){
            take = f(idx, amt - coins[idx], coins, dp);
        }
        return dp[idx][amt] = take + notTake;
    }
}

        
