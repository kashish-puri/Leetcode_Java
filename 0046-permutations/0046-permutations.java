class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        perm(nums, result, freq, new ArrayList<>());
        return result;
    }
    public void perm(int[] nums, List<List<Integer>> result, boolean[] freq, ArrayList<Integer> curr){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!freq[i]){
                curr.add(nums[i]);
                freq[i] = true;
                perm(nums, result, freq, curr);
                freq[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

}