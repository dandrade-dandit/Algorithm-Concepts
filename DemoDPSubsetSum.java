public class DemoDPSubsetSum {

    static boolean SubsetSumBottomUpDP (int[] val, int wtGoal) {
        boolean[][] T = new boolean[val.length][wtGoal+1];

        for (int i = 0; i < val.length; i++) { //row
            for (int j = 0; j <=  wtGoal; j++) { //col
                if (j < val[i]) {
                    if (j == 0) {
                        T[i][j] = true;
                        continue;
                    }
                    if (i == 0) {
                        T[i][j] = false;
                    } else {
                        T[i][j] = T[i-1][j];
                    }
                } else {
                    if (i == 0 && j == val[i]) {
                        T[i][j] = true;
                        continue;
                    } else if (i == 0 && j > val[i]) {
                        T[i][j] = false;
                        continue;
                    }

                    if (T[i-1][j]) {
                        T[i][j] = true;
                    }
                    else {
                        T[i][j] =  T[i-1][j-val[i]];
                    }
                }
            }
        }

        return T[val.length-1][wtGoal];
    }

    public static void main(String[] args) {
        int n =11;
        int [] val = {2, 3, 7, 8, 10};

        System.out.println("The Subset Sum Problem - Dynamic Programing (Bottom Up) Solution is: " + SubsetSumBottomUpDP(val, n));
    }
}
