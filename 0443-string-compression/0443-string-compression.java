class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int writeIndex = 0;

        while(i < chars.length){
            char currentChar = chars[i];
            int count = 0;

            while(i < chars.length && chars[i] == currentChar){
                count++;
                i++;
            }

            chars[writeIndex] = currentChar;
            writeIndex++;

            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[writeIndex++] = c;
                }
            }
        }
        return writeIndex;
    }
}