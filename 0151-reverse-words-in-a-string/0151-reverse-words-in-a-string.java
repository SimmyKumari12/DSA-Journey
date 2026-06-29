class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String ans = "";
        int right = s.length() - 1;

        while(right >= 0){
            int left = right;
            while(left >= 0 && s.charAt(left) != ' '){
                left--;
            }

            if(ans.isEmpty()){
                ans += s.substring(left + 1, right + 1);
            } else{
                ans += ' ' + s.substring(left + 1,right + 1);
            }

            while(left >= 0 && s.charAt(left) == ' '){
                left--;
            }

            right = left;
        }
        return ans;
    }
}