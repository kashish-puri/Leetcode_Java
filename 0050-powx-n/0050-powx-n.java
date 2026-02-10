class Solution {
    public double myPow(double x, int n) {
        return conv(x,(long)n);
    }
    public double conv(double x,long n){
        if(n==0) return 1;
        if(n<0) return conv(1/x,-n);
        if(n%2==0) return conv(x*x,n/2);
        return conv(x*x,n/2)*x;
    }
}