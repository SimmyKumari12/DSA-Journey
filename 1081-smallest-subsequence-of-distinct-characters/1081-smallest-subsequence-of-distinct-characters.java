class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26]; //last index where each candidate appears
        boolean[] vis = new boolean[26];

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(vis[c - 'a']){
                continue;
            }

            while(!st.isEmpty() && st.peek() > c && last[st.peek() - 'a'] > i){
                vis[st.pop() - 'a'] = false;
            }

            st.push(c);
            vis[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }

        return sb.toString();
    }
}