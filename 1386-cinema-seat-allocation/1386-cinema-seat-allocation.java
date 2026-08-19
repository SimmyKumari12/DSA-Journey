class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int group = 0;
        boolean groupA = true;
        boolean groupB = true;
        boolean groupC = true;

        for(int[] row : reservedSeats){
            map.putIfAbsent(row[0],new ArrayList<>());
            map.get(row[0]).add(row[1]);
        }

        int count = map.size();

        for(int k : map.keySet()){
            groupA = true;
            groupB = true;
            groupC = true;


            for(int v : map.get(k)){
                if(v == 2 || v == 3 || v == 4 || v == 5){
                    groupA = false;
                }
                if(v == 4 || v == 5 || v == 6 || v == 7){
                    groupB = false;
                }
                if(v == 6 || v == 7 || v == 8 || v == 9){
                    groupC = false;
                }
            }

            if(groupA && groupC){
                group+=2;
            } else if(groupA || groupB || groupC){
                group += 1;
            }
        }

        group += (n - count) * 2;
        return group;
    }
}