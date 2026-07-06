class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0]- b[0];
        });

        int n = intervals.length;
        int size = 0;
        int maxEnd = 0;

        for(int[] interval : intervals){
            int currEnd = interval[1];

            if(currEnd > maxEnd){
                maxEnd = currEnd;
                size++;
            }
        }
        return size;
    }
}