public class ConstructSegTree {
    static int tree[];

    public static void init(int n){
        tree = new int[4 * n];
    }

    public static int buildBST(int[] arr, int i, int start, int end){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/ 2;

        buildBST(arr, 2 * i + 1, start, mid);
        buildBST(arr, 2 * i + 2, mid + 1, end);

        tree[i] = tree[2* i + 1] + tree[2*i+2];
        return tree[i];
    }

    //Query Opearation in Segment Trees
    public static int getSumUtil(int i, int qi, int qj, int si, int sj){
        //We have to fit a segment inside a query 
        if(qj < si || sj < qi ){//Case 1: No overlapping
            return 0; 
        } else if(qi <= si && qj >= sj){//Case 2: Complete Overlap
            return tree[i];
        } else{//Partial Overlapping
            int mid = (si + sj)/2;
            int left = getSumUtil(2*i+1, qi, qj,si,mid);
            int right = getSumUtil(2*i+2,qi,qj,mid+1,sj);
            return left+right;
        }
    }

    public static int getSum(int[] arr, int qi, int qj){
        int n = arr.length;
        return getSumUtil(0,qi,qj,0,n - 1);
    }

    //Update Operation in Segment Trees
    public static void doUpdate(int[] arr, int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        doUpdateUtil(0,0,n-1,idx,diff);
    }

    public static void doUpdateUtil(int i, int si, int sj, int idx, int diff){
        //Check if that specific index lies in the range
        if(idx < si || idx > sj){
            return;
        }

        tree[i] = tree[i] + diff;
        if(si != sj){
            int mid = (si + sj)/ 2;
            doUpdateUtil(2*i+1,0,mid,idx,diff);
            doUpdateUtil(2*i+2,mid+1,sj,idx,diff);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        init(arr.length);
        buildBST(arr, 0, 0, arr.length - 1);

        // for(int i = 0; i < tree.length; i++){
        //     System.out.print(tree[i] + " ");
        // }

        System.out.println(getSum(arr, 2, 5));
        doUpdate(arr,2,2);
        System.out.println(getSum(arr, 2, 5));
    }
}
