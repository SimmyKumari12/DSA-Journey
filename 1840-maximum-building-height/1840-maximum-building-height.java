class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,0});

        for(int[] r : restrictions){
            list.add(r);
        }

        list.add(new int[]{n,n-1});//Max height

        Collections.sort(list,(a,b) -> a[0] - b[0]);

        int m = list.size();

        //Forward Pass
        for(int i = 1; i < m; i++){
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(list.get(i)[1] , list.get(i-1)[1] + dist);
        }

        //Backward Pass
        for(int i = m - 2; i >= 0; i--){
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i + 1)[1] + dist);
        }

        int maxHt = 0;

        for(int i = 1; i < list.size(); i++){
            int idx1 = list.get(i-1)[0];
            int ht1 = list.get(i-1)[1];

            int idx2 = list.get(i)[0];
            int ht2 = list.get(i)[1];

            int dis = idx2 - idx1;
            int peak = (ht1 + ht2 + dis)/ 2;

            maxHt = Math.max(peak,maxHt);
        }
        return maxHt;
    }
}