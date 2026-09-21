class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            int[] curr = intervals[i];
            int startC = curr[0];
            int endC = curr[1];

            for(int j = i + 1; j < n; j++){
                int[] pair = intervals[j];
                if(endC >= pair[0] && startC <= pair[1]){
                    count++;
                }
            }
        }
        return count;
    }
}