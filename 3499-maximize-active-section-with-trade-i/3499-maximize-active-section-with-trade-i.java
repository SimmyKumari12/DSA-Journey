class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int cnt = 0;
        int maxSum = 0;
        int possum = 0;

        for(int i = 0; i < n; i++){
            if(i != 0 && s.charAt(i) != s.charAt(i - 1)){
                ans.add(cnt);
                cnt = 0;
            }
            if(s.charAt(i) == '0'){
                cnt = cnt - 1;
            } else{
                cnt = cnt + 1;
            }
        }
        ans.add(cnt);

        for(int i : ans){
            if(i > 0){
                possum += i;
            }
        }
         
        maxSum = possum;
        int m = ans.size();
        for(int i = 1; i < m - 1; i++){
            if(ans.get(i - 1)  < 0 && ans.get(i + 1) < 0 && ans.get(i) > 0){
                int prev = ans.get(i - 1);
                int later = ans.get(i + 1);
                maxSum = Math.max(maxSum,possum + Math.abs(prev + later));
            }
        }
        return maxSum;
    }
}