class Solution { 
    public int[] validSequence(String word1, String word2) { 
        char[] s = word1.toCharArray(); 
        char[] t = word2.toCharArray(); 
        int n = s.length; 
        int m = t.length; 
        
        // suffix[i] stores the maximum length of a suffix of word2 
        // that can be formed by a subsequence of word1 starting at index i.
        int[] suffix = new int[n + 1]; 
        int j = m - 1; 
        for (int i = n - 1; i >= 0; i--) { 
            if (j >= 0 && s[i] == t[j]) { 
                j--; 
            } 
            suffix[i] = m - 1 - j; 
        } 
        
        int[] ans = new int[m]; 
        int i = 0; 
        j = 0; 
        boolean changed = false;

        while (i < n && j < m) { 
            if (s[i] == t[j]) { 
                ans[j] = i; 
                j++; 
            } else if (!changed && suffix[i + 1] >= m - j - 1) { 
                // Use the 1 allowed change here
                ans[j] = i; 
                j++; 
                changed = true; 
            }
            i++; 
        } 
        
        return j == m ? ans : new int[0]; 
    } 
}
