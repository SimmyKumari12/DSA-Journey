class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }

        ArrayList<Character> list = new ArrayList<>();
        String ans = "";
        int m = s.length();

        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
                list.add(ch);
            }
        }

        int vowelIdx = list.size() - 1;
        for(int i = 0; i < m; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
                ans += list.get(vowelIdx);
                vowelIdx--;
            } else{
                ans += ch;
            }
        }
        return ans;
    }
}