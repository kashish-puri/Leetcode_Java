class Solution {
    int N=1000000;
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
    public List<List<Integer>> findPrimePairs(int n) {
        sieve();
        List<List<Integer>> ans=new ArrayList<>();
        int l=2,r=n-1;
        while(l<=r){
            if(prime[l]==0){
                l++;
                continue;
            }
            if(prime[r]==0){
                r--;
                continue;
            }
            if(l+r==n){
                List<Integer> temp=new ArrayList<>();
                temp.add(l);
                temp.add(r);
                ans.add(temp);
                l++;
                r--;
            }else if(l+r<n){
                l++;
            } else{
                r--;
            }
        }
        return ans;
    }
}