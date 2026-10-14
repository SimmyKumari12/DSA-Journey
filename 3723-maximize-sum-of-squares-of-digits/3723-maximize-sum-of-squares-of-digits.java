class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();
        if(sum > 9 * num){
            return "";
        }

        int nines = sum / 9;
        int rem = sum % 9;

        for(int i = 0; i < nines; i++){
            ans.append('9');
        }

        if(ans.length() < num){
            ans.append(rem);
        }

        while(ans.length() < num){
            ans.append('0');
        }

        return ans.toString();
    }
}