class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        
        int lastA = -1;
        int lastB = -1;
        int lastC = -1;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == 'a') lastA = i; 
            else if(ch == 'b') lastB = i;
            else lastC = i;

            if(lastA != -1 && lastB != -1 && lastC != -1){
                int minIdx =  Math.min(lastA,Math.min(lastB,lastC));
                ans += minIdx + 1;
            }
        }
        return ans;
    }
}