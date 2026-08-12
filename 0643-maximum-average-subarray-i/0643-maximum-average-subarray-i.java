class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if(n == 1){
            return (double)nums[0];
        }
        int sum = 0;
        double res = Double.NEGATIVE_INFINITY;;
        int start = 0;

        for(int end = 0; end < n; end++){
            sum += nums[end];

            if(end - start + 1 == k){
                double average = (double)sum / k;

                res = Math.max(res,average);

                sum -= nums[start];
                start++;
            }
        }
        return res;
    }
}