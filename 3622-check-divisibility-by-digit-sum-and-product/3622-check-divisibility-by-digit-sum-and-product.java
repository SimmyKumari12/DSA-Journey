class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int mul = 1;
        int val = n;

        if(n / 10 == 0){
            return false;
        }

        while(val > 0){
            sum += val % 10;
            mul *= val % 10;
            val = val/10;
        }

        int ans = sum + mul;
        if(ans % n == 0 || n % ans == 0){
            return true;
        }
        return false;
    }
}