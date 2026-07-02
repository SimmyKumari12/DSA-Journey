class Solution {
    public int myAtoi(String s) {
        if(s.isEmpty()) return 0;

        int n = s.length();
        int idx = 0;
        int sign = 1; //1 for positive, -1 for negative
        int result = 0;

        //Whitespaces
        while(idx < n && s.charAt(idx) == ' '){
            idx++;
        }

        if(idx == n){
            return 0;
        }

        //Sign
        if(s.charAt(idx) == '-'){
            sign = -1;
            idx++;
        } else if(s.charAt(idx) == '+'){
            idx++;
        }

        //Overflow and Conversion and Rounding
        while(idx < n){
            char ch  = s.charAt(idx);

            if(ch < '0' || ch > '9'){
                break;
            }

            int digit = ch - '0';

            if(result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10){
                return (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            idx++;
        }
        return result * sign;
    }
}