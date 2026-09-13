class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){
            list.add(num);
        }

        int count = 0;

        for(int i = 1; i < 2001; i++){
            if(!list.contains(i)){
                count++;
            }

            if(count == k){
                return i;
            }
        }
        return -1;
    }
}