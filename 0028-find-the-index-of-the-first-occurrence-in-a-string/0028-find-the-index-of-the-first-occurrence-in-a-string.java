class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int[] lps = findLPS(needle);
        int i = 0;
        int j = 0;

        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }

            if(j == m){
                return i - m;
            } 

            else if(i < n && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                } else{
                    i++;
                }
            }
        }
        return -1;
    }

    public int[] findLPS(String needle){
        int m = needle.length();
        int[] lps = new int[m];

        lps[0] = 0;
        int i = 1;
        int len = 0;

        while(i < m){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else{
                if(len != 0){
                    len = lps[len - 1];
                } else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}