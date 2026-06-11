class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int index = 0;
        int minIdxSum = Integer.MAX_VALUE;

        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i < list1.length; i++){
            map.put(list1[i],i);
        }

        for(int j = 0; j < list2.length; j++){
            if(map.containsKey(list2[j])){
                index = map.get(list2[j]) + j;
                if(minIdxSum > index){
                    ans.clear();
                    ans.add(list2[j]);
                    minIdxSum = index;
                }else if(minIdxSum == index){
                    ans.add(list2[j]);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}