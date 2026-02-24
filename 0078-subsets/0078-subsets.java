class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public void backtrack(int[] nums, int idx, List<Integer> curr){
        if(idx==nums.length){
            result.add(curr);
            return;
        }
        List<Integer> include=new ArrayList<>(curr);
        include.add(nums[idx]);
        backtrack(nums, idx+1,include);

        backtrack(nums, idx+1, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        backtrack(nums,0,ans);
        return result;
    }
}