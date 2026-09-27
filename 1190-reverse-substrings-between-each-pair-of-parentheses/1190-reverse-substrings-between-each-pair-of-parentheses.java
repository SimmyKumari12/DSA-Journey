class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();

        while(sb.indexOf(")") != -1){
            int end = sb.indexOf(")");
            int start = sb.lastIndexOf("(",end);

            String ans = sb.substring(start + 1,end);
            String reversed = new StringBuilder(ans).reverse().toString();

            sb.replace(start,end + 1, reversed);
        }
        return sb.toString();
    }
}