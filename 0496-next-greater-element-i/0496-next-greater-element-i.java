class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int curr:nums2){
            while(!st.isEmpty() && curr>st.peek()){
                int top=st.pop();
                map.put(top,curr);
            }
            st.push(curr);
        }
        while(!st.isEmpty()){
            int top=st.pop();
            map.put(top,-1);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}