class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        Set<Integer> ans = new HashSet<>();

        for(int i = 0; i < n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }

        for(int num : set){
            if(ans.contains(map.get(num))){
                return false;
            }else{
                ans.add(map.get(num));
            }
        }
        return true;
    }
}