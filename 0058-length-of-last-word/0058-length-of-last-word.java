class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int right = s.length() - 1;
        int count = 0;

        while(right >= 0 && s.charAt(right) != ' '){
            count++;
            right--;
        }

        return count;
    }
}