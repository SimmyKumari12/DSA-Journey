class Solution {
    public String smallestPalindrome(String s) {
        int[] counts = new int[26];
        for(char ch : s.toCharArray()){
            counts[ch - 'a']++;
        }

        StringBuilder leftHalf = new StringBuilder();
        String mid = "";
        boolean hasMid = false;

        for(int i = 0; i < 26; i++){
            int count = counts[i];
            if(count == 0) continue;

            char ch = (char)(i + 'a');

            if(count % 2 != 0){
                mid += ch;
                hasMid = true;
            }

            int half = count/2;
            for(int j = 0; j < half; j++){
                leftHalf.append(ch);
            }
        }

        String leftStr = leftHalf.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();

        if(hasMid){
            return leftStr + mid + rightStr;
        }
        return leftStr + rightStr;
    }
}