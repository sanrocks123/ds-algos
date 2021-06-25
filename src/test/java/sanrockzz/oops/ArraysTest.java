package sanrockzz.oops;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source ArraysTest.java created on Jun 5, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class ArraysTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testLargestSumContugousSubarray() {

        final int a[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };

        int sum = 0;
        int currentSum = 0;
        for (final int element : a) {
            currentSum = currentSum + element;

            if (currentSum > sum) {
                sum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        log.info("sum: {}", sum);
    }

    @Test
    public void testProductArrayPuzzleTest() {

        final int a[] = new int[] { 10, 3, 5, 6, 2 };
        final int r[] = new int[a.length];
        for (int i = 0; i <= a.length - 1; i++) {

            r[i] = findProduct(a, 0, i - 1) * findProduct(a, i + 1, a.length - 1);
        }

        for (int i = 0; i <= r.length - 1; i++) {
            log.info("a[{}] : {}", i, r[i]);
        }

    }

    @Test
    public void testReverse() {

        final int a[] = new int[] { 1, 2, 3, 4, 5 };

        for (final Integer i : a) {
            log.info("before reversal : {}", i);
        }

        for (int i = 0, j = a.length - 1; i != j; i++, j--) {
            final int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

        for (final Integer i : a) {
            log.info("after reversal : {}", i);
        }
    }

    /**
     * @param i
     * @param j
     * @return
     */
    private int findProduct(int[] a, int i, int j) {
        if (i > a.length - 1 || j < 0) {
            return 1;
        }

        int result = 1;
        for (int k = i; k <= j; k++) {
            result = result * a[k];
        }

        return result;
    }

}
