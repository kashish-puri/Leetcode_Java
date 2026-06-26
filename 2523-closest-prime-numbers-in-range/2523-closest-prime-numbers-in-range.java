class Solution {
    int N=10000001;
    int[] prime=new int[N];
    public void sieve(){
        Arrays.fill(prime, 1);
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i*i<N;i++){
            if(prime[i]==1){
                for(int j=i*i;j<N;j+=i){
                    prime[j]=0;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        sieve();
        int[] arr={-1,-1};
        int prev=-1;
        int diff=Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(prime[i]==0) continue;
            if(prev!=-1 && i-prev<diff){
                diff=i-prev;
                arr[0]=prev;
                arr[1]=i;
            }
            prev=i;
        }
        return arr;
    }
}