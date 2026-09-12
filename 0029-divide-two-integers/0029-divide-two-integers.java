class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean neg = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long result = 0;
        while(dvd >= dvs){
            long divid = 1, divis = dvs;
            while(divis + divis <= dvd){
                divis = divis + divis;
                divid = divid + divid;
            }
            dvd = dvd - divis;
            result += divid;
        }
        if(neg) return -(int)result;
        return (int)result;
    }
}