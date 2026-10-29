class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m == 0) return 0;
        int len = 0, j = 1;
        int[] lps = new int[m];

        while(j < m){
            if(needle.charAt(j) == needle.charAt(len)){
                lps[j++] = ++len;
            }else if(len > 0){
                len = lps[len - 1];
            }else{
                lps[j] = 0;
                j++;
            }
        }
        int i = 0, k = 0;
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(k)){
                i++;
                k++;
                if(k == m) return i - k;
            }else if(k > 0){
                k = lps[k - 1];
            }else i++;
        }
        return -1;
    }
}