class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();

        for(int i = 0; i < senate.length(); i++){
            char ch = senate.charAt(i);

            if(ch == 'R'){
                r.offer(i);
            } else{
                d.offer(i);
            }
        }
        // r = [0] , d = [1,2]
        while(!r.isEmpty() &&  !d.isEmpty()){
            if(r.peek() < d.peek()){
                d.poll();
                r.offer(r.poll() + n);
            } else{
                r.poll();
                d.offer(d.poll() + n);
            }
        }

        if(r.isEmpty()){
            return "Dire";
        }

        return "Radiant";
    }
}