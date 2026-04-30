class Solution {
    public boolean check(int[] nums) {
        int[] arr = new int[nums.length];
        //Trying Different x values
        for(int x = 0; x < nums.length; x++){
            for(int i = 0; i < nums.length; i++){
                arr[i] = nums[(i + x) % nums.length];
            }
            //Checking if after using that Array is sorted or not 
            boolean sorted = true;
            for(int i = 1; i < nums.length; i++){
                if(arr[i - 1] > arr[i]){
                    sorted = false;
                    break;
                }
            }
            if(sorted == true){
                return true;
            }
        }
        return false;
    }
}