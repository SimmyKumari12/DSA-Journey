class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        int rem = n % 10;
        max = Math.max(max,rem);
        n/=10;

        while(n != 0){
            rem = n % 10;
            if(rem >= max){
                secMax = max;
            } else{
                secMax = Math.max(secMax,rem);
            }
            max = Math.max(max,rem);
            n/=10;
        }
        return max * secMax;
    }
}