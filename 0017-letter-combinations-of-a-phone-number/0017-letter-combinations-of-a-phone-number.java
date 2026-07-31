class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        ArrayList<String> list = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(0,curr,digits,list,map);
        return list;
    }

    public void helper(int idx, StringBuilder curr, String digits, ArrayList<String> list, HashMap<Character,String> map){
        if(idx == digits.length()){
            list.add(curr.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx));

        for(char letter :letters.toCharArray()){
            curr.append(letter);
            helper(idx + 1,curr,digits,list,map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}