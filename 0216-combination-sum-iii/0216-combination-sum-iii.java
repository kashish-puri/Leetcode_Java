class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        comb(n, 0, k, 1, new ArrayList<>(), result);
        return result;
    }
    public void comb(int n, int sum, int k, int idx, ArrayList<Integer> curr, List<List<Integer>> result){
        if(curr.size() == k && sum == n){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() == k || sum > n || idx > 9) return;
        
        curr.add(idx);
        comb(n, sum + idx, k, idx + 1 , curr, result);
        curr.remove(curr.size() - 1);
        comb(n, sum, k, idx + 1, curr, result);
    }
    
}