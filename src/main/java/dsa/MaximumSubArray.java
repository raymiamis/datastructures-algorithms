package dsa;

public class MaximumSubArray {

    /**
     * Algorithm to compute the maximum subarray of an array filled with negative and positive numbers
     * O(n³) - naive approach
     * @param numbers int array to be searched in
     * @return sum of the max subarray values
     */
    public static int maxSumNaive(int[] numbers) {
        int maxSum = 0;
        for (int u = 0; u < numbers.length; u++) {
            for (int o = u; o < numbers.length; o++) {
                int sum = 0;

                for (int i = u; i <= o; i++) {
                    sum += numbers[i];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /**
     * Algorithm to compute the maximum subarray of an array filled with negative and positive numbers
     * O(n²) - slightly better
     * @param numbers int array to be searched in
     * @return sum of the max subarray values
     */
    public static int maxSumQuad(int[] numbers) {
        int maxSum = 0;
        for (int u = 0; u < numbers.length; u++) {
            int sum = 0;

            for (int o = u; o < numbers.length; o++) {

                sum += numbers[o];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    /**
     * Algorithm to compute the maximum subarray of an array filled with negative and positive numbers
     * using divide and conquer principles. O(nlog(n)) - best
     * @param numbers int array to be searched in
     * @param left index 0
     * @param right max index
     * @return sum of the max subarray values
     */
    public static int maxSumDivideConquer(int[] numbers, int left, int right) {
        if (right == left) {
            return numbers[left];
        }
        int mid = (left + right) / 2; // Mitte des Arrays
        int maxLeft = maxSumDivideConquer(numbers, left, mid);
        int maxRight = maxSumDivideConquer(numbers, mid + 1, right);

        int midLeftMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= left; i--) {
            sum += numbers[i];
            if (sum > midLeftMax)
                midLeftMax = sum;
        }

        int midRightMax = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += numbers[i];
            if (sum > midRightMax)
                midRightMax = sum;
        }

        return Math.max(Math.max(maxLeft, maxRight), midLeftMax+midRightMax);
    }

}
