class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 != 0){
            return false;
        }

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else{
                if(st.isEmpty()){
                    return false;
                } else{
                    char top = st.peek();
                    if((ch == ')' && top == '(')|| (ch == '}' && top == '{') || (ch == ']' && top == '[')){
                        st.pop();
                    } else{
                        return false;
                    }
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}