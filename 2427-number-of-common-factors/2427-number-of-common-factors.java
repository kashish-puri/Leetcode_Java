class Solution {
    public int commonFactors(int a, int b) {
        int gcd=findGcd(a,b);
        int count=0;
        for(int i=1;i<=gcd;i++){
            if(gcd%i==0) count++;
        }
        return count;
    }
    int findGcd(int a, int b){
        if(b==0) return a;
        return findGcd(b,a%b);
    }
}