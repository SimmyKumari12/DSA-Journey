class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String a = str1 + str2;
        String b = str2 + str1;

        if(!a.equals(b)){
            return "";
        }

        int n = str1.length();
        int m = str2.length();

        int val = findGcd(n,m);

        return str1.substring(0,val);
    }

    public int findGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}