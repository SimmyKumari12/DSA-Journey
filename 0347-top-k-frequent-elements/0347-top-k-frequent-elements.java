class Pair{
    int ele;
    int freq;

    public Pair(int ele, int freq){
        this.ele = ele;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        int[] ans = new int[k];
        int i = 0;

        while(k > 0){
            Pair curr = pq.poll();
            ans[i++] = curr.ele;
            k--;
        }

        return ans;
    }
}