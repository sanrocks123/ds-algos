package sanrockzz.oops;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
    public void testArrayAlternateSorting() {
        final int[] arr = { 1, 2, 3, -4, -1, 4 };

        Arrays.sort(arr);
        for (final int a : arr) {
            System.out.print(a);
        }

        int posStartIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                posStartIdx = i;
                break;
            }
        }
        int j = posStartIdx;
        for (int i = 0; i < posStartIdx; i++) {

            if (i % 2 == 0) {
                if (arr[i] > 0) {
                    final int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            }
            else {
                if (arr[i] < 0) {
                    final int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            }
        }

        System.out.println("\n");
        for (final int a : arr) {
            System.out.print(a);
        }

    }

    @Test
    public void testDuplicateNumbers() {

        final int arr[] = { 1, 2, 3, 1, 3, 6, 6 };

        for (int i = 0; i < arr.length; i++) {
            final int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            }
            else {
                System.out.println(j + " ");
            }
        }
    }

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

            if (currentSum <= 0) {
                currentSum = 0;
            }
        }
        log.info("sum: {}", sum);
    }

    // Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
    // Output: 4

    @Test
    public void testLongestConsecutiveSubsequence() {
        final Set<Integer> hash = new HashSet<>();
        final int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        for (final int a : arr) {
            hash.add(a);
        }

        int maxCount = Integer.MIN_VALUE;
        for (final int a : arr) {

            if (!hash.contains(a - 1)) {

                final int start = a;
                int next = start;
                int count = 0;

                while (hash.contains(next)) {
                    next++;
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        log.info("max count : {}", maxCount);
    }

    @Test
    public void testNonRepeatingFirstChar() {

        final String str = "GeeksForGeeks";
        final char[] cArr = str.toCharArray();

        final Map<String, Integer> map = new LinkedHashMap<>();
        for (final char c : cArr) {
            map.computeIfPresent(Character.valueOf(c).toString(), (k, v) -> v + 1);
            map.computeIfAbsent(Character.valueOf(c).toString(), a -> 1);
        }

        log.info("map: {}", map);

        for (final Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                log.info("first non repeating char: {}", entry.getKey());
                break;
            }
        }
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

    @Test
    public void testSeggregateEvenOdd() {

        final int[] arr = { 1, 2, 3, 4, 5, 6 };

        int prevOdd = -1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {
                prevOdd++;
                final int temp = arr[prevOdd];
                arr[prevOdd] = arr[i];
                arr[i] = temp;
            }
        }

        for (final int e : arr) {
            System.out.print(e);
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
