class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int currNum = 0;
        String currStr = "";

        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = (currNum * 10) + ch - '0';
            } else if(ch == '['){
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            } else if(ch == ']'){
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());

                for(int j = 0; j < repeat; j++){
                    temp.append(currStr);
                }

                currStr = temp.toString();
            } else{
                currStr += ch;
            }
        }
        return currStr;
    }
}