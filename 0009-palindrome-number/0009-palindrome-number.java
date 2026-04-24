class Solution {
    public boolean isPalindrome(int x) {
        int ans = x;
        int rev = 0;
        //Base Conditions
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        if(x == 0){
            return true;
        }
        while(x > rev){ // 11 >= 0
            int digit = x % 10; // 1
            rev = (rev * 10) + digit; //1
            x = x / 10; //1
        }
        return (x == rev || x == rev / 10);
    }
}