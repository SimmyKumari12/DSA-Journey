class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int m = n / 3;
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+ 1);
        }

        for(int entry : map.keySet()){
            if(map.get(entry)>m){
                ans.add(entry);
            }
        }
        return ans;
    }
}