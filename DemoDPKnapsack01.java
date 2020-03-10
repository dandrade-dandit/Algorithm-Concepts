public class DemoDPKnapsack01 {

    static int Knapsack01BottomUpDP (int[] wt, int[] val, int wtGoal) {
        int[][] T = new int[wt.length][wtGoal+1];

        for (int i = 0; i < wt.length; i++) { //row
            for (int j = 1; j <=  wtGoal; j++) { //col
                if (j < wt[i]) {
                    if (i == 0) {
                        T[i][j] = 0;
                        continue;
                    }
                    T[i][j] = T[i-1][j];
                } else {
                    if (i == 0) {
                        T[i][j] = val[i];
                        continue;
                    }
                    T[i][j] = Math.max(val[i] + T[i-1][j-wt[i]], T[i-1][j]);
                }
            }
        }

        return T[wt.length-1][wtGoal];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int wtGoal = 7;

        System.out.println(Knapsack01BottomUpDP(wt, val, wtGoal));

    }
}
