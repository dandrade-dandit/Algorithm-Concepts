public class DemoDPKnapsack01 {

    static int Knapsack01BottomUpDP (int[] wt, int[] val, int wtGoal) {
        //0/1 Knapsack Dynamic Programing - BottomUP
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
        int[] wt = {5,6,8,4,7,2};
        int[] val = {50,50,64,46,50,5};
        int wtGoal = 19;

        System.out.println(Knapsack01BottomUpDP(wt, val, wtGoal));

    }
}
