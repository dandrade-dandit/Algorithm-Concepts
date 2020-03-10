public class DemoDPMinEditDistance {

    static int MinEditDistanceBottomUpDP(String s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] T = new int[str1.length+1][str2.length+1];

        for (int i = 0; i <= str1.length; i++){
            for (int j = 0; j <= str2.length; j++){
                if (i == 0 ) {
                    T[0][j] = j;
                    continue;
                } else if (j == 0) {
                    T[i][0] = i;
                    continue;
                }

                if (str1[i-1] == str2[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else {
                    T[i][j] = Math.min(Math.min(T[i-1][j], T[i-1][j-1]), T[i][j-1]) + 1;
                }
            }
        }

        return T[str1.length][str2.length];
    }

    public static void main(String[] args) {
        String str1 = "impartial"; //"abcdef";
        String str2 = "parallel"; //"azced";

        System.out.println(MinEditDistanceBottomUpDP(str1, str2));
    }
}
