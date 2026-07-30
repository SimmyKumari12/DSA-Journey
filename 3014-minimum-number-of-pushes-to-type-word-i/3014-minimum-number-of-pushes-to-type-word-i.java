class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        if(n <= 8){
            return n;
        } else if(n > 8 && n < 17){
            int twoPush = n - 8;
            ans = 8 + (twoPush * 2);
        } else if(n > 16 && n < 25){
            int threePush = n - 16;
            ans = 24 + (threePush * 3);
        } else{
            int fourPush = n - 24;
            ans = 48 + (fourPush * 4);
        }
        return ans;
    }
}