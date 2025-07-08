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

    public static void computeFullShift(int[] shiftArray, int[] longSuffixArray, String pattern) {
        int n = pattern.length();
        int i = n;
        int j = n+1;
        longSuffixArray[i] = j;
        while(i > 0) {

            while(j <= n && pattern.charAt(i-1) != pattern.charAt(j-1)) {

                if(shiftArray[j] == 0) {
                    shiftArray[j] = j-i;
                }

                j = longSuffixArray[j];
            }
            i--;
            j--;
            longSuffixArray[i] = j;
        }
    }

    public static void computeGoodSuffix(int[] shiftArray, int[] longSuffixArray, String pattern) {

        int n = pattern.length();
        int j;
        j = longSuffixArray[0];

        for(int i = 0; i<n; i++) {

            if(shiftArray[i] == 0) {
                shiftArray[i] = j;
                if(i == j) {

                    j = longSuffixArray[j];
                }
            }
        }
    }

    /**
     * Boyer-Moore string search - not my code because too complicated rn
     * @param text text to be searched within
     * @param pattern pattern to be searched for
     * @param foundPositions array holding all the found positions
     * @param index {-1}
     */
    public static void boyerMooreSearch(String text, String pattern, int[] foundPositions, int[] index) {

        int patLen = pattern.length();

        int strLen = text.length();
        int[] longerSuffArray = new int[patLen+1];
        int[] shiftArr = new int[patLen + 1];

        for(int i = 0; i<=patLen; i++) {
            shiftArr[i] = 0;
        }

        computeFullShift(shiftArr, longerSuffArray, pattern);
        computeGoodSuffix(shiftArr, longerSuffArray, pattern);
        int shift = 0;
        while(shift <= (strLen - patLen)) {
            int j = patLen - 1;

            while(j >= 0 && pattern.charAt(j) == text.charAt(shift+j)) {
                j--;
            }
            if(j < 0) {
                index[0]++;

                foundPositions[index[0]] = shift;
                shift += shiftArr[0];
            }else {
                shift += shiftArr[j+1];
            }
        }
    }

}
