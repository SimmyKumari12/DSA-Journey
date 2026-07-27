class Solution {
    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for(int num : nums){
            if(num >= firstMax){
                secMax = firstMax;
            }else{
                secMax = Math.max(num,secMax);
            }
            firstMax = Math.max(num,firstMax);
        }

        return (firstMax - 1) * (secMax - 1);
    }
}