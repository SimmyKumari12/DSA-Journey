class Solution {
    public int maxDigitRange(int[] nums) {
        int maxDigRange = -1;
        int sum = 0;

        for (int num : nums) {
            int currentRange = getDigitRange(num);
            if (currentRange > maxDigRange) {
                maxDigRange = currentRange;
            }
        }

        for (int num : nums) {
            if (getDigitRange(num) == maxDigRange) {
                sum += num;
            }
        }

        return sum;
    }

    private int getDigitRange(int num) {
        int min = 9;
        int max = 0;
        int temp = num;

        while (temp > 0) {
            int rem = temp % 10;
            min = Math.min(min, rem);
            max = Math.max(max, rem);
            temp = temp / 10;
        }

        return max - min;
    }
}
