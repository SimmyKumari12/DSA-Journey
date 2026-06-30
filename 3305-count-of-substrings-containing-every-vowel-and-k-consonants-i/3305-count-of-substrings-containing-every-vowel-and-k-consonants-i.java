class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;
        int idx = n - 5 - k;
        
        for(int i = 0; i <= n; i++){
            int freqA = 0;
            int freqE = 0;
            int freqI = 0;
            int freqO = 0;
            int freqU = 0;
            int freqCon = 0;
            for(int j = i; j <n; j++){
                char ch = word.charAt(j);
                
                if (ch == 'a') freqA++;
                else if (ch == 'e') freqE++;
                else if (ch == 'i') freqI++;
                else if (ch == 'o') freqO++;
                else if (ch == 'u') freqU++;
                else freqCon++; 
                
                if (freqA >= 1 && freqE >= 1 && freqI >= 1 && freqO >= 1 && freqU >= 1 && freqCon == k) {
                    count++;
                }
            }
        }
        return count;
    }
}