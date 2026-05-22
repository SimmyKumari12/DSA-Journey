class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1] - a[1]);

        int maxBoxes = 0;

        for(int[] pair : boxTypes){
            int boxes = pair[0];
            int units = pair[1];

            int take = Math.min(truckSize,boxes);

            maxBoxes = maxBoxes + (take * units);

            truckSize = truckSize - take;

            if(truckSize <= 0) break;
        }

        return maxBoxes;
    }
}