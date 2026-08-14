class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;

        for(int end = 0; end < n; end++){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0) + 1);

            while(map.get(s.charAt(end)) > 2){
                map.put(s.charAt(start),map.get(s.charAt(start)) - 1);
                start++;
            }

            res = Math.max(res,end - start + 1);
        }
        return res;
    }
}