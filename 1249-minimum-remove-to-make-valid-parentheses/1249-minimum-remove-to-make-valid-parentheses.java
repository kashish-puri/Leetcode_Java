class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int[] removed = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(i);
            else if(ch == ')'){
                if(!st.isEmpty()) st.pop();
                else removed[i] = 1;
            }
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            removed[idx] = 1;
        } 
        for(int i = 0; i < s.length(); i++){
            if(removed[i] == 0) ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}