class Solution {

    public int precedence(char ch) {
        if(ch == '~') return 2;
        if(ch == '+' || ch == '-') return 1;
        return -1;
    }

    public String infixToPostfix(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        boolean expectNumber = true;

        for(int i = 0; i < s.length();) {

            char ch = s.charAt(i);

            if(ch == ' ') {
                i++;
            }

            else if(Character.isDigit(ch)) {

                while(i < s.length() &&
                      Character.isDigit(s.charAt(i))) {

                    ans.append(s.charAt(i));
                    i++;
                }

                ans.append(' ');
                expectNumber = false;
            }

            else if(ch == '(') {

                st.push(ch);
                i++;

                expectNumber = true;
            }

            else if(ch == ')') {

                while(!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                    ans.append(' ');
                }

                st.pop();
                i++;

                expectNumber = false;
            }

            else {

                // Unary + or -
                if(expectNumber) {

                    if(ch == '-') {
                        st.push('~');
                    }

                    i++;
                }

                // Normal operator
                else {

                    while(!st.isEmpty() &&
                          st.peek() != '(' &&
                          precedence(st.peek()) >= precedence(ch)) {

                        ans.append(st.pop());
                        ans.append(' ');
                    }

                    st.push(ch);
                    i++;

                    expectNumber = true;
                }
            }
        }

        while(!st.isEmpty()) {
            ans.append(st.pop());
            ans.append(' ');
        }

        return ans.toString();
    }

    public int calculate(String s) {

        String ans = infixToPostfix(s);

        Stack<Long> st = new Stack<>();
        StringBuilder num = new StringBuilder();

        for(int i = 0; i < ans.length(); i++) {

            char ch = ans.charAt(i);

            // Number
            if(Character.isDigit(ch)) {
                num.append(ch);
            }

            // Space
            else if(ch == ' ') {

                if(num.length() > 0) {

                    st.push(Long.parseLong(num.toString()));

                    num.setLength(0);
                }
            }

            // Unary minus
            else if(ch == '~') {

                long x = st.pop();

                st.push(-x);
            }

            // + or -
            else {

                long second = st.pop();
                long first = st.pop();

                if(ch == '+') {
                    st.push(first + second);
                }
                else {
                    st.push(first - second);
                }
            }
        }

        return st.pop().intValue();
    }
}