class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0; i < s.length();i++){
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] vis = new boolean[26];
        Stack<Character> st = new Stack<>();

        //cbacdcbc
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i); //c,b,a,c,d,c,b

            if(vis[ch - 'a']){
                continue;
            }

            while(!st.isEmpty() && st.peek() > ch && last[st.peek() - 'a'] > i){
                vis[st.pop() - 'a'] = false;
            }

            st.push(ch);//st.push(c);[a,c,d,b]
            vis[ch - 'a'] = true; //vis[c] = true
        }

        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}