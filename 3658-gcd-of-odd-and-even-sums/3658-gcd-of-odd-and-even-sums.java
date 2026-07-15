class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 1;
        int sumEven = 2;
        int gcd1 = 1;
        int gcd2 = 2;

        while(n > 1){
            sumOdd += 2;
            gcd1 += sumOdd;
            sumEven += 2;
            gcd2 += sumEven;
            n--;
        }

        while(gcd2 != 0){
            int temp = gcd2;
            gcd2 = gcd1 % gcd2;
            gcd1 = temp;
        }
        return gcd1;
    }
}