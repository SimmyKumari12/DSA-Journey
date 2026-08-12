class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int res = 0;
        int start = 0;
        int count = 0;

        for(int end = 0; end < n; end++){
            char ch = s.charAt(end);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }

            if(end - start + 1 == k){
                res = Math.max(res, count);
                if(s.charAt(start) == 'a' || s.charAt(start) == 'e' || s.charAt(start) == 'i' || s.charAt(start) == 'o' || s.charAt(start) == 'u'){
                    count -= 1;
                }
                start++;
            }
        }
        return res;
    }
}