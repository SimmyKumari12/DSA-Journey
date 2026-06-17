class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        //Forward Pass
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                len++;
            } else if(ch == '*'){
                if(len > 0){
                    len = len - 1;
                }
            } else if(ch == '#'){
                len = len * 2;
            }
        }

        if(len < k + 1) return '.';

        //Reverse Pass
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                if(k == len - 1) return ch;
                len--;
            } else if(ch == '*'){
                len++;
            } else if(ch == '#'){
                len = len / 2;
                if(k >= len){
                    k = k - len;
                }
            } else if(ch == '%'){
                k = len - 1 - k;
            }
        }
        return '.';
    }
}