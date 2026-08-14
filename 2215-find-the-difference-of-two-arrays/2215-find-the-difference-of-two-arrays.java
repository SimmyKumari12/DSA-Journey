class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            list.add(new ArrayList<>());
        }       
        
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();

        for(int val : nums1){
            first.add(val);
        }

        for(int val : nums2){
            second.add(val);
        }

        for(int num : first){
            if(!second.contains(num)){
                list.get(0).add(num);
            }
        }

        for(int num : second){
            if(!first.contains(num)){
                list.get(1).add(num);
            }
        }

        return list;
    }
}