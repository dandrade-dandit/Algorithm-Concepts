import java.util.Arrays;

public class DemoBinarySearch {

    static boolean BinarySearch (int[] A, int key, int start, int end) {
        int mid = (start + end)/2;
        if (A[mid] == key) {
            return true;
        } else {
            if (end <= start) {
                return false;
            } else {
                if (A[mid] > key) {
                    return BinarySearch(A, key, start, mid-1);
                } else {
                    return BinarySearch(A, key, mid+1, end)  ;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] SampleArr = {4,5,7,9,13,16,14,15,19,2}; //must be sorted.
        int key = 20;
        Arrays.sort(SampleArr);
        System.out.println("The result for a Binary Search of " + key + " is: " + BinarySearch(SampleArr,key,0,SampleArr.length-1));

    }
}
