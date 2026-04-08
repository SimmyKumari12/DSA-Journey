class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String ans = "";

        for(int i = s.length() - 1; i >= 0; i--){
            ans = ans + s.charAt(i);
        }

        return s.equals(ans);
    }
}