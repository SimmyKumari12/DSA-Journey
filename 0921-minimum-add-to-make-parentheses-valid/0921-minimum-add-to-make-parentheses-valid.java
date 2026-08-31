class Solution {
    public int minAddToMakeValid(String s) {
        int openPar = 0;
        int closePar = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                openPar++;
            } else if(ch == ')' && openPar > 0){
                openPar--;
            } else{
                closePar++;
            }
        }
        return openPar + closePar;
    }
}