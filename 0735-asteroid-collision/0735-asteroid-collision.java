class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for(int num : nums){
            boolean alive = true;
            if(num > 0){
                st.push(num);
            } else{
                while(alive && !st.isEmpty() && st.peek() > 0){
                    if(st.peek() < -num){
                        st.pop();
                    } else if(st.peek() == -num){
                        alive = false;
                        st.pop();
                    } else{
                        alive = false;
                    }
                }

                if(alive){
                    st.push(num);
                }
            }
        }

        int m = st.size();
        int[] ans = new int[m];

        for(int i = m - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}