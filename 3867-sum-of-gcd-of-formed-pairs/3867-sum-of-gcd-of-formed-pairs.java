class Solution {
    public long gcdSum(int[] nums) {
        long[] prefixGcd = new long[nums.length];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i],max);
            prefixGcd[i] = findGcd(max,nums[i]);
        }

        Arrays.sort(prefixGcd);
        long sum = 0;

        int left = 0;
        int right = prefixGcd.length - 1;

        while(left < right){
            sum += findGcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }

    public long findGcd(long a , long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}