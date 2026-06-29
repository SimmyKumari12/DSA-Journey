class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";

        for(int i = 0; i < n; i++){
            String oddAns = helper(s,i,i);
            String evenAns = helper(s,i - 1,i);

            if(oddAns.length() > ans.length()){
                ans = oddAns;
            }

            if(evenAns.length() > ans.length()){
                ans = evenAns;
            }
        }

        return ans;
    }

    public String helper(String s, int left, int right){
        String ans = "";
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        ans = s.substring(left + 1, right);
        return ans;
    }
}