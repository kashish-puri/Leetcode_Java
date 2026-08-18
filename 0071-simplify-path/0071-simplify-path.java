class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");
        for(String part : parts){
            if(part.isEmpty() || part.equals(".")) continue;
            else if(part.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else st.push(part);
        }
        StringBuilder sb = new StringBuilder();
        for(String curr : st){
            sb.append("/").append(curr);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}