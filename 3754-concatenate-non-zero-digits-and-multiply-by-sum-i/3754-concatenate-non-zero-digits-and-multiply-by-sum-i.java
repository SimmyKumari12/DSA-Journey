class Solution {
    public long sumAndMultiply(int n) {
        long num = 0, sum = 0;
        String s = String.valueOf(n);

        for(char ch : s.toCharArray()){
            if(ch != '0'){
                long digit = ch - '0';
                sum = sum + digit;

                num = (num * 10) + digit;
            }
        }
        return num * sum;
    }
}