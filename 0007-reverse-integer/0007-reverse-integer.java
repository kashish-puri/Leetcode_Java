class Solution {
    public int reverse(int x) {
        int temp = x;
        int rev = 0;
        int rem = 0;
        while(temp != 0){
            rem = temp % 10;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && rem < -8) || rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && rem > 7)){
                return 0;
            }
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        return rev;
    }
}