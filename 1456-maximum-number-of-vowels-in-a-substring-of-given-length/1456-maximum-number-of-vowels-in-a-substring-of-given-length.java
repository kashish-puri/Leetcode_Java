class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)) count++;
        }
        int max = count;
        int n = s.length();
        for(int i = k; i < n; i++){
            if(isVowel(s.charAt(i))) count++;
            if (isVowel(s.charAt(i - k))) count--;
            max = Math.max(max,count);
        }
        return max;
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}