public class DemoGrAlAcititySelectionProblem {

    static void SortActivities (String[] A, int[] S, int[] F) {
        int n = F.length;

        for (int i = 1; i < n; ++i) {
            int keyF = F[i];
            int keyS = S[i];
            String keyA = A[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && F[j] > keyF) {
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

    public static void printMaxActivities(String a[], int s[], int f[], int n)
    {
        int i, j;

        System.out.print("Following activities are selected : ");

        // The first activity always gets selected
        i = 0;
        System.out.print(a[i]+":[s:" + s[i] + " -> f:" + f[i] + "] ");

        // Consider rest of the activities
        for (j = 1; j < n; j++)
        {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it
            if (s[j] >= f[i])
            {
                System.out.print(a[j]+":[s:" + s[j] + " -> f:" + f[j] + "] ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        String[] A = {"A1", "A2", "A3", "A4", "A5", "A6"};  // A3, A2, A1, A5, A4, A6
        int[] S = {0, 3, 1, 5, 5, 8};                       // 1, 3, 0, 5, 5, 8
        int[] F = {6, 4, 2, 9, 7, 9};                       // 2, 4, 6, 7, 9, 9

        SortActivities (A, S, F);

        printMaxActivities(A, S, F, S.length);
    }
}
