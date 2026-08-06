class Solution {
    public int smallestNumber(int n, int t) {
        int ans = 0;

        for(int i = n; i <= 100; i++){ // n = 10, t = 2
            int mul = 1; //mul = 1;
            int val = i; //val = 10

            while(val != 0){ //10 != 0
                int rem = val % 10; // rem = 10 % 10 = 0, rem = 1 % 10 = 1
                mul *= rem; //mul = 1 * 0 = 0, mul = 0 * 1 = 0
                val = val / 10; //10/10 = 1, 1/ 10 = 0
            }

            if(mul % t == 0){ //0 % 2 == 0
                ans = i;
                break;
            }
        }
        return ans;
    }
}