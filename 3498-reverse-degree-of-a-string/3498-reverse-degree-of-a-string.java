class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            int revIdx = ('z' - ch) + 1;
            int idx = i + 1;
            ans += revIdx * idx;
        }
        return ans;
    }
}