class Pair{
    int val;
    int freq;
    int idx;

    public Pair(int val, int freq, int idx){
        this.val = val;
        this.freq = freq;
        this.idx = idx;
    }
}

class FreqStack {
    int len;
    HashMap<Integer,Integer> map;
    PriorityQueue<Pair> pq;

    public FreqStack() {
        len = 0;
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq){
                return b.freq - a.freq;
            }
            return b.idx - a.idx;
        });
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val, 0) + 1);
        pq.offer(new Pair(val,map.get(val),++len));
    }
    
    public int pop() {
        Pair curr = pq.poll();
        int prevFreq = map.get(curr.val);
        map.put(curr.val,prevFreq - 1);
        return curr.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */