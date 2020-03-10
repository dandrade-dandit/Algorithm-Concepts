public class DemoDQQuickSort {

    static int Partition (int[] A, int low, int high) {
        int pivot = A[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                i++;
                Swap(A, i, j);
            }
        }
        Swap(A, (i +1), high);
        return i + 1;
    }

    static int PartitionLow (int[] A, int low, int high) {
        int pivot = A[low];
        int i = low;
        for (int j = (low + 1); j <= high; j++) {
            if (A[j] <= pivot) {
                i++;
                Swap(A, i, j);
            }
        }
        Swap(A, i, low);
        return i;
    }

    static void Swap (int[] A, int From, int To) {
        int temp = A[From];
        A[From] = A[To];
        A[To] = temp;
    }

    static void QuickSort (int[] A, int low, int high) {
        int q = 0;
        if (low < high) {
            q = PartitionLow(A, low, high);
            QuickSort(A, low, (q - 1));
            QuickSort(A, (q + 1), high);
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
        QuickSort(A,0, A.length-1);
        printArray(A);
    }
}
