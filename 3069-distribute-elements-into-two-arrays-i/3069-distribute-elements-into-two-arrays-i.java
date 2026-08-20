class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        int i = 0;
        list2.add(nums[1]);
        int j = 0;

        for(int k = 2; k < n; k++){
            if(list1.get(i) > list2.get(j)){
                list1.add(nums[k]);
                i++;
            } else{
                list2.add(nums[k]);
                j++;
            }
        }

        int idx = 0;
        for(int num : list1){
            ans[idx++] = num;
        }
        for(int num : list2){
            ans[idx++] = num;
        }
        return ans;
    }
}