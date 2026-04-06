class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st= new Stack<>();
        Map<Integer, Integer> mp= new HashMap<>();
        for(int curr : nums2){
            while(!st.isEmpty() && curr > st.peek()){
                int top=st.pop();
                mp.put(top, curr);
            }
            st.push(curr);
        }
        while(!st.isEmpty()){
            mp.put(st.pop(),-1); //remaining elements ka koi next greater element nahi h isliye -1 
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=mp.get(nums1[i]);
        }
        return ans;
    }
}