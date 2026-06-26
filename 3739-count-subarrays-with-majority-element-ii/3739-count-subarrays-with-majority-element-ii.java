class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        int cumSum = 0;

        long validLeftPoints = 0;
        long result = 0;

        map.put(cumSum, 1);

        for(int j = 0; j < n; j++){
            if(nums[j] == target){
                validLeftPoints += map.getOrDefault(cumSum,0);
                cumSum += 1;
            } else{
                cumSum -= 1;
                validLeftPoints -= map.getOrDefault(cumSum,0);
            }

            result = result + validLeftPoints;
            map.put(cumSum,map.getOrDefault(cumSum,0) + 1);
        }
        return result;
    }
}