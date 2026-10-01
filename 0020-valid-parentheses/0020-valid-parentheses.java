class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else if(st.isEmpty()){
                return false;
            } else if((ch == ')' && st.peek() != '(') || (ch == '}' && st.peek() != '{') || (ch == ']' && st.peek() != '[')){
                return false;
            } else{
                st.pop();
            }
        }
        if(st.size() >= 1){
            return false;
        }
        return true;
    }
}