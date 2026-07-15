class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start = toSeconds(startTime);
        int end = toSeconds(endTime);
        int ans = 0;

        if(end >= start){
            ans = end - start;
        }
        return ans;
    }

    public int toSeconds(String time){
        String[] parts = time.split(":");

        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);

        return h * 3600 + m * 60 + s;
    }
}