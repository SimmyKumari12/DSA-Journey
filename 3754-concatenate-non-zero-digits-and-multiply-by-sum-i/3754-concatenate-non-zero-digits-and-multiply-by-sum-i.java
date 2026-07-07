class Solution {
    public long sumAndMultiply(int n) {
        String st = String.valueOf(n);
        String ans = "";

        if(n == 0){
            return 0;
        }

        for(char ch : st.toCharArray()){
            if(ch - '0' != 0){
                ans = ans + ch;
            }
        }

        long x = Integer.parseInt(ans);
        long val = x;
        long sum = 0;

        while(val > 0){
            sum = sum + (val % 10);
            val = val/10;
        }

        return sum * x;
    }
}