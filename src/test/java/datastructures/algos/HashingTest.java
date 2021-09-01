package datastructures.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source HashingProblemTest.java created on Jul 22, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class HashingTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testDistinctElementInEvryWindowOfSizeK() {

        final int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        System.out.println("i/p list : " + Arrays.stream(arr).boxed().collect(Collectors.toList()));

        final Map<Integer, Integer> hm = new HashMap<>();

        final int window = 4;
        for (int i = 0; i < window; i++) {
            hm.computeIfPresent(arr[i], (k, v) -> v + 1);
            hm.computeIfAbsent(arr[i], v -> 1);
        }

        System.out.println(hm.size());

        for (int i = window; i < arr.length; i++) {

            final int prev = i - window;

            if (hm.get(arr[prev]) == 1) {
                hm.remove(arr[prev]);
            }
            else {
                hm.put(arr[prev], hm.get(arr[prev]) - 1);
            }

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            System.out.println(hm.size());

        }

    }

    @Test
    public void testHashMap() {

        final int[] arr = { 1, 1, 2, 3, 2 };

        final Map<Integer, Integer> map = new HashMap<>();

        for (final int e : arr) {
            map.computeIfPresent(e, (k, v) -> v + 1);
            map.computeIfAbsent(e, v -> 1);
        }
        System.out.println(map);

        final String s = "Listen";
        final String s1 = "Silent";

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + s.charAt(i) - s1.charAt(i);
            System.out.println(sum);

        }
        System.out.printf("count : %s", sum);
    }

    @Test
    public void testLongestConsecutiveSubsequence() {
        final Set<Integer> hash = new HashSet<>();
        final int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        for (final int a : arr) {
            hash.add(a);
        }

        int maxCount = Integer.MIN_VALUE;
        for (final int a : arr) {

            // check for start sequence
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
    public void testNumberOfWays() {

        final int[] arr = { 1, 2, 3, 4, 3 };
        final int sum = 6;

        final Map<Integer, Integer> map = new HashMap<>();

        for (final int element : arr) {
            map.computeIfPresent(element, (k, v) -> v + 1);
            map.computeIfAbsent(element, v -> 1);
        }

        System.out.println(map);

        final Set<String> pairs = new HashSet<>();

        for (final int element : arr) {

            final int temp = sum - element;

            if (map.containsKey(temp)) {
                final int oldValue = map.get(temp);
                final int newValue = oldValue - 1;

                if (newValue == 0) {
                    map.remove(element);
                }
                else {
                    map.put(temp, newValue);
                }
                final String s = String.format("%s%s", element, temp);
                pairs.add(s);

                System.out.printf("pair found: %s\n", s);
            }
        }

        System.out.println(pairs);

    }

}
