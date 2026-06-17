class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        check(0,s,new ArrayList<>(),res);
        return res;
    }

    void check(int i,String s, List<String> curr, List<List<String>> res){
        if(i == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalin(s,i,j)){
                curr.add(s.substring(i,j + 1));
                check(j + 1,s,curr,res);
                curr.remove(curr.size() - 1);
            }
        }        
    }

    boolean isPalin(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}