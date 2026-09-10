class Solution {
    int N = 1000001;
    boolean[] prime = new boolean[N];
    public void sieve(){
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i * i < N; i++){
            if(prime[i] == true){
                for(int j = i * i; j < N; j += i){
                    prime[j] = false;
                }
            }
        }

    }
    public int[] closestPrimes(int left, int right) {
        sieve();
        int[] arr = {-1,-1};
        int prev = -1, diff = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++){
            if(prime[i]){
                if(prev != -1 && i - prev < diff){
                    diff = i - prev;
                    arr[0] = prev;
                    arr[1] = i;
                }
                prev = i;
            }
            
        }
        return arr;
    }
}