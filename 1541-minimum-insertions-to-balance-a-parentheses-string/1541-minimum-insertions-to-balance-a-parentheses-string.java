class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            } else{
                if(i + 1 < n && s.charAt(i + 1) == ')'){
                    i++;
                } else{
                    ans++;
                }

                if(open > 0){
                    open--;
                } else{
                    ans++;
                }
            }
        }
        ans += open << 1;
        return ans;
    }
}