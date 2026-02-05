class Solution {
    public void rev(char[] s,int left,int right){
        if(left>=right) return;
        //yaha hum swap krenge using two pointers
        char temp=s[left];
        s[left]=s[right];
        s[right]=temp;
        rev(s,left+1,right-1);
    }
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
}