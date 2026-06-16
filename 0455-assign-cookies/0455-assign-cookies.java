class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int left = 0;
        int right = 0;

        while(left < g.length && right < s.length){
            if(g[left] <= s[right]){
                cnt++;
                left++;
                right++;
            } else{
                right++;
            }
        }
        return cnt;
    }
}