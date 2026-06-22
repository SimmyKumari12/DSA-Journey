class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        int ans = Integer.MAX_VALUE;

        for(char c : s.toCharArray()){
            freqS[c - 'a']++;
        }

        for(char c : target.toCharArray()){
            freqT[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freqT[i] > 0){
                ans = Math.min(ans,freqS[i] / freqT[i]);
            }
        }

        return ans;
    }
}