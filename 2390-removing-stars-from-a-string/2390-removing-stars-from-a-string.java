class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                st.pop();
            } else{
                st.push(ch);
            }
        }

        for(char ch : st){
            sb.append(ch);
        }

        return sb.toString();
    }
}