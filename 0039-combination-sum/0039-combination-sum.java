class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    public void findCombinations(int[] candidates, int idx, int target, ArrayList<Integer> curr, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (idx == candidates.length || target < 0) {
            return;
        }
        curr.add(candidates[idx]);
        findCombinations(candidates, idx, target - candidates[idx], curr, ans);
        curr.remove(curr.size() - 1);
        findCombinations(candidates, idx + 1, target, curr, ans);
    }
}