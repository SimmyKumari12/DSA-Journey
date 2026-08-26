class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int countOnes = 0;
        String ans = "";

        for(int end = 0; end < n; end++){
            if(s.charAt(end) == '1'){
                countOnes++;
            }

            while(countOnes > k){
                if(s.charAt(start) == '1'){
                    countOnes--;
                }
                start++;
            }
            if(countOnes == k){
                while(s.charAt(start) == '0'){
                    start++;
                }
                String curr = s.substring(start,end + 1);
                int m = curr.length();

                if(m < minLength){
                    minLength = m;
                    ans = curr;
                } else if(m == minLength){
                    if(ans == ""){
                        ans = curr;
                    } else if(curr.compareTo(ans) < 0){
                        ans = curr;
                    }
                }
            }
        }
        return ans;
    }
}