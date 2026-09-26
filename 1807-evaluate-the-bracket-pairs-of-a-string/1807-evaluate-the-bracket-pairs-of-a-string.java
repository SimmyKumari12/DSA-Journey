class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0),list.get(1));
        }

        StringBuilder ans = new StringBuilder();
        int idx = 0;
        int n = s.length();

        while(idx < n){
            char curr = s.charAt(idx);

            if(curr == '('){
                idx++;
                int start = idx;

                while(idx < n && s.charAt(idx) != ')'){
                    idx++;
                }

                String key = s.substring(start,idx);
                ans.append(map.getOrDefault(key,"?"));
                idx++;
            } else{
                ans.append(curr);
                idx++;
            }
        }
        return ans.toString();
    }
}