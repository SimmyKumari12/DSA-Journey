class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == 'a'){
                continue;
            } else if(i < n - 1 && (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a')){
                return false;
            }
        }
        return true;
    }
}