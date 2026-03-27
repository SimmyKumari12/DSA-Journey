public class MCM_Recursion {

    public static int mcmRec(int[] arr, int i , int j ){
        if(i == j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            int ans1 = mcmRec(arr,i, k);
            int ans2 = mcmRec(arr, k+1, j);
            int ans3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = ans1 + ans2 + ans3;

            ans = Math.min(finalCost,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(mcmRec(arr, 1, arr.length - 1));
    }
}
