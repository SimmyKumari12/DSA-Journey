class Solution {
    public double angleClock(int hour, int minutes) {
        double minAns = 0;
        hour = hour % 12;

        double ans = Math.abs((30 * hour) - (5.5 * minutes));
        minAns = Math.min(ans,360 - ans);

        return minAns;
    }
}