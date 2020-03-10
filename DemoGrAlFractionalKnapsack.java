public class DemoGrAlFractionalKnapsack {

    static double FractionalKnapsack (int[] wt, int[] val, int w) {
        double r = 0;
        double[] valByWt = new double[wt.length];

        for (int i = 0; i < wt.length; i++){
            valByWt[i] = (double)val[i] / (double)wt[i];
        }
        Sort(valByWt, val, wt);

        for (int j = valByWt.length-1; j >= 0; j--) {
            if (w >= wt[j]) {
                r += val[j];
                w -= wt[j];
            } else if (w < wt[j] && w > 0) {
                r += w * valByWt[j];
                w -= w;
            }
        }
        return r;
    }

    static void Sort (double[] A, int[] S, int[] F) {
        int n = A.length;

        for (int i = 1; i < n; ++i) {
            int keyF = F[i];
            int keyS = S[i];
            double keyA = A[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && A[j] > keyA) {
                F[j + 1] = F[j];
                S[j + 1] = S[j];
                A[j + 1] = A[j];
                j = j - 1;
            }
            F[j + 1] = keyF;
            S[j + 1] = keyS;
            A[j + 1] = keyA;
        }
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 5, 4, 1, 3, 2};
        int[] val = {5, 10, 15, 7, 8, 9, 4};
        int wtGoal = 15;
        System.out.println(FractionalKnapsack(wt, val, wtGoal));
    }
}
