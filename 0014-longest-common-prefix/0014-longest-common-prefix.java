class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String prefix = strs[0];

        for(int i = 1; i < n; i++){
            String curr = strs[i];

            int j = 0;
            while(j < prefix.length() && j < curr.length() && prefix.charAt(j) == curr.charAt(j)){
                j++;
            }

            prefix = prefix.substring(0,j);

            if(prefix.length() == 0){
                return prefix;
            }
        }
        return prefix;
    }
}