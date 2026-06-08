class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        for(int right = 0; right <= n - 1; right++){ // right = 0,1,2,3,4,5,6
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));// remove a,b,b
                left++; //left++,left = 2,3,
            }

            set.add(s.charAt(right)); // [a,c,b]

            maxLen = Math.max(maxLen, right - left + 1);    
        }

        return maxLen;
    }
}