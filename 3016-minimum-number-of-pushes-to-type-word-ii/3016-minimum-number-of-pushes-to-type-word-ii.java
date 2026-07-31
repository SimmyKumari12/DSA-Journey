class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for(char ch : word.toCharArray()){
            count[ch - 'a']++;
        }
        Arrays.sort(count);
        int ans = 0;

        for(int i = 25; i >= 0; i--){
            if(i >= 18){
                ans += count[i];
            } else if(i >= 10 && i <= 17){
                ans += count[i] * 2;
            }else if(i >= 2 && i < 10){
                ans += count[i] * 3;
            } else{
                ans += count[i] * 4;
            }
        }
        return ans;
    }
}