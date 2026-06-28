class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        //Rearranging
        Arrays.sort(arr);
        if(arr[0] != 1){
            arr[0] = 1;
        }

        //Decreasing
        for(int i = 1; i < n; i++){
            if(Math.abs(arr[i] - arr[i - 1]) > 1){
                arr[i] = arr[i - 1] + 1;
            }
        }

        //After rearranging and decreasing
        int ans = Integer.MIN_VALUE;
        for(int num : arr){
            ans = Math.max(ans,num);
        }
        return ans;
    }
}