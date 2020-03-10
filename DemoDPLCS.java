import java.util.Arrays;

public class DemoDPLCS {

    static int LCSBottomUpDP(String s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] T = new int[str1.length + 1][str2.length + 1];

        for (int i = 0; i <= str1.length; i++){
            for (int j = 0; j <= str2.length; j++){
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                    continue;
                }

                if (str1[i-1] == str2[j-1]) {
                    T[i][j] = T[i-1][j-1]+1;
                } else {
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
                }
            }
        }

        return T[str1.length][str2.length];
    }

    static int LCSMemDP (String s1, String s2, int i, int j, int[][] T) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int result = 0;

        if (i == str1.length || j == str2.length) return 0;

        // if the same state has already been
        // computed
        if (T[i][j] != -1) return T[i][j];

        if (str1[i] == str2[j]) {
            result += LCSNaive(s1, s2, i+1, j+1) + 1;
        } else {
            result += Math.max(LCSNaive(s1, s2, i+1, j), LCSNaive(s1, s2, i, j+1));
        }

        T[i][j] = result;
        return result;
    }

    static int LCSNaive (String s1, String s2, int i, int j) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        if (i == str1.length || j == str2.length) return 0;
        if (str1[i] == str2[j]) {
            return LCSNaive(s1, s2, i+1, j+1) + 1;
        } else {
            return Math.max(LCSNaive(s1, s2, i+1, j), LCSNaive(s1, s2, i, j+1));
        }
    }

    public static void main(String[] args) {
        String str1 = "abcb"; //"abcdef";
        String str2 = "bdcab"; //"azced";

        System.out.println("Naive Solution: " + LCSNaive(str1, str2, 0, 0));
        System.out.println("Bottom Up (DP) Solution: " + LCSBottomUpDP(str1, str2));

        int[][] T = new int[str1.length() + 1][str2.length() + 1];
        // assign -1 to all positions
        for (int[] row : T) {
            Arrays.fill(row, -1);
        }
        System.out.println("Memoization (DP) Solution: " + LCSMemDP(str1, str2, 0, 0, T));
    }
}
