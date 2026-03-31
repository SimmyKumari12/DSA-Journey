public class MaxSegmentTree{
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildST(int[] nums, int i, int si, int sj){
        if(si==sj){
            tree[i] = nums[si];
            return;
        }
        int mid = (si + sj)/2;

        buildST(nums, 2*i+1, si, mid);
        buildST(nums, 2*i+2, mid+1, sj);  
        tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
    }

    public static void main(String[] args){
        int[] nums = {6,8,-1,2,17,1,3,2,4};
        int n = nums.length;
        init(n);
        buildST(nums, 0, 0, n-1);

        for(int i = 0; i < tree.length;i++){
            System.out.print(tree[i] + " ");
        }
    }
}