class Solution {
    public void sub(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result){
        if(idx==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        sub(nums, idx+1, curr, result);
        curr.add(nums[idx]);
        sub(nums, idx+1, curr, result);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        sub(nums, 0, curr, result);
        return result;
    }
}