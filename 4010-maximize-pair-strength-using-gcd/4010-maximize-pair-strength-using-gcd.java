class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long mul = (long)nums[i] * nums[j];
                long gcd = findGcd(nums[i],nums[j]);
                long val = mul / (long)(Math.pow(gcd,2));
                ans = Math.max(ans,val);           
            }
        }
        return ans;
    }

    public int findGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}