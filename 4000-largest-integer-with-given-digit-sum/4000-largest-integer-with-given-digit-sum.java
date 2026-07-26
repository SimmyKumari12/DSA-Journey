class Solution {
    public int largestInteger(int n, int s) {
        int ans = -1;
        int left = 0;
        int right = 0;
        if(s == 0){
            return 0;
        }
        if(n == 1){
            left = 0;
            right = 9;
        } else if(n == 2){
            left = 10;
            right = 99;
        } else if(n == 3){
            left = 100;
            right = 999;
        } else if(n == 4){
            left = 1000;
            right = 9999;
        } else{
            left = 10000;
            right = 99999;
        }

        for(int i = left; i <= right; i++){
            int val = i;
            int sum = 0;
            while(val != 0){
                int rem = val % 10;
                sum = sum + rem;
                val = val / 10;
            }
            if(sum == s){
                ans = Math.max(ans,i);
            }
        }
        return ans;
    }
}