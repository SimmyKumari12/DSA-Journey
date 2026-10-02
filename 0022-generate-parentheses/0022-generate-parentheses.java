class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s ="";
        recurse(0,0,n,s,ans);
        return ans;
    }

    public void recurse(int left, int right, int n, String s,List<String> ans){
        if(n * 2 == s.length()){
            ans.add(s);
            return;
        }

        //left
        if(left < n){
            recurse(left + 1, right,n, s + '(',ans);
        }

        //right
        if(right < left){
            recurse(left,right + 1,n, s + ')',ans);
        }
    }
}