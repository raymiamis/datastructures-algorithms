package dsa;

public class StringSearch {

    /**
     * Simple bruteforce string search algorithm, simple but effective.
     * @param text text to be searched within
     * @param pattern pattern to be searched for
     * @return index of the first occurrence, or -1 if not found
     */
    public static int bruteForceSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {

            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static int boyerMooreSearch(String text, String pattern) {
        //  TODO
        return -1;
    }

}
