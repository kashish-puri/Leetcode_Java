class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        comb(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    public void comb(int[] candidates, int idx, int target, ArrayList<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length || target < 0) return;
        curr.add(candidates[idx]);
        comb(candidates, idx, target - candidates[idx], curr, result);
        curr.remove(curr.size() - 1);
        comb(candidates, idx + 1, target, curr, result);
    }
}