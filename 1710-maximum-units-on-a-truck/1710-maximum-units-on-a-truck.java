class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> list = new ArrayList<>();
        int n = boxTypes.length;

        for(int[] box : boxTypes){
            list.add(new int[]{box[1],box[0]});
        }

        list.sort((x,y) -> y[0] - x[0]);

        int maxBoxes = 0;

        for(int[] pair : list){
            int noOfUnits = pair[0];
            int boxOfType = pair[1];

            int take = Math.min(truckSize,boxOfType);

            maxBoxes = maxBoxes + (take * noOfUnits);

            truckSize = truckSize - take;

            if(truckSize <= 0) break;
        }

        return maxBoxes;
    }
}