class Solution {
    public boolean checkPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        check(s,0,result,new ArrayList<>());
        return result;
    }
    public void check(String s, int idx, List<List<String>> result, List<String> curr){
        if(idx == s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(checkPalindrome(s, idx, i)){
                curr.add(s.substring(idx, i + 1));
                check(s, i + 1, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}