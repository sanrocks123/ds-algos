package datastructures.algos;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Java Source FacebookTest.java created on Jul 16, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class FacebookPuzzleTest {

    /**
     *
     * @param N
     * @param K
     * @param M
     * @param S
     * @return
     */
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here

        final Set<Long> hash = new HashSet<>();
        for (final Long s : S) {
            hash.add(s);
        }

        long seatsAvailable = 0;

        for (long i = 1; i <= N; i++) {

            if (hash.contains(i)) {
                continue;
            }

            boolean isSeatAlreadyOccupied = false;

            // left traversal & right traversal till k
            for (long j = 1; j <= K; j++) {
                Long x = i - j;
                if (hash.contains(x)) {
                    isSeatAlreadyOccupied = true;
                    break;
                }
                x = i + j;
                if (hash.contains(x)) {
                    isSeatAlreadyOccupied = true;
                    break;
                }
            }

            if (isSeatAlreadyOccupied) {
                continue;
            }

            hash.add(Long.valueOf(i));
            seatsAvailable++;

            System.out.printf("current seat found: %d, seatsAvailable: %d, seatsSoFar: %s\n", i, seatsAvailable, hash);

        }
        return seatsAvailable;
    }

    @Test
    public void testDiningTableProblem() {
        final long[] S = { 2, 6 };
        Assert.assertEquals(3, getMaxAdditionalDinersCount(10, 1, 2, S));

        final long[] S1 = { 11, 6, 14 };
        Assert.assertEquals(1, getMaxAdditionalDinersCount(15, 2, 3, S1));
    }

}
