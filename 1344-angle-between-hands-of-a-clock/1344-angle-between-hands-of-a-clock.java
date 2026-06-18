class Solution {
    public double angleClock(int hour, int minutes) {
        double minAns = 0;
        if(hour == 12){
            double ans = Math.abs(5.5 * minutes);
            minAns = Math.min(ans, 360 - ans);
        } else{
            double sol = Math.abs((30 * hour) - (5.5 * minutes));
            minAns = Math.min(sol,360-sol);
        }
        return minAns;
    }
}