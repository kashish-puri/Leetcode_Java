
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (s.charAt(j) == s.charAt(i)) {
                lps[j++] = ++i;
            } else if (i > 0) {
                i = lps[i - 1];
            } else {
                lps[j] = 0;
                j++;
            }
        }

        return s.substring(0, lps[n - 1]);
    }
}
