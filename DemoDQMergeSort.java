public class DemoDQMergeSort {

    public static void MergeSort (int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            MergeSort(A,p,q);
            MergeSort(A,q+1, r);
            Merge(A, p, q, r);
        }
    }

    public static void Merge (int[] A, int p, int q, int r) {
        int n1 = (q - p) + 1;
        int n2 = (r - q);
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for (int i = 1; i <= n1; i++) {
            L[i-1] = A[p+i-1];
        }
        for (int j = 1; j <= n2; j++) {
            R[j-1] = A[q+j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {38,27,43,3,9,82,10,1,33,48,70,65,57,16};
        printArray(A);
        MergeSort(A,0, A.length-1);
        printArray(A);
    }
}
