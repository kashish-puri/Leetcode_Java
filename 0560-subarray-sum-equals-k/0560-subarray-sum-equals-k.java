class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int num : nums){
            prefix += num;
            if(mp.containsKey(prefix - k)){
                count += mp.get(prefix - k);
            }
            mp.put(prefix, mp.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}