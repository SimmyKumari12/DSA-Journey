class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> sum = new ArrayList<>();

        if(n <= 2){
            return sum;
        }

        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            List<Integer> row = new ArrayList<>();
            row.add(nums[i]);
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
                    sum.add(triplet);
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if(nums[left] + nums[right] > target){
                    right--;
                } else{
                    left++;
                }
            }
        }
        return sum;
    }
}