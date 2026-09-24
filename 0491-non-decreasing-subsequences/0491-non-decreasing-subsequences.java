class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sub(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void sub(int[] nums, int idx, List<List<Integer>> result, ArrayList<Integer> curr) {
        if (curr.size() >= 2) {
            result.add(new ArrayList<>(curr));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;
            if (curr.size() > 0 && nums[i] < curr.get(curr.size() - 1))
                continue;
            set.add(nums[i]);
            curr.add(nums[i]);
            sub(nums, i + 1, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}