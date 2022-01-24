/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package general.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source CollectionTest.java created on Dec 21, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class CollectionTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testBinarySearch() {
        final List<String> str = Arrays.asList(new String[] { "mumbai", "pune", "new york", "sydney" });
        Collections.sort(str);

        log.info("sorted list: {}", str);
    }

    @Test
    public void testCollectionEqualsTest() {
        final List<String> str = Arrays.asList(new String[] { "a", "b", "c", "a" });
        final Set<String> set = new HashSet<>(str);
        final Set<String> ss = new TreeSet<>(str);
        Assert.assertTrue(set.equals(ss));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemoval() {
        final List<String> list = Arrays.asList(new String[] { "a", "b", "c", "a" });
        final Iterator<String> itr = list.iterator();
        list.remove("a");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void testMaxValueInMap() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 5);
        map.put("c", 2);
        map.put("d", 1);

        final int max = map.entrySet().stream().max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1).get()
                .getValue();
        System.out.printf("max value: %d", max);
    }

    @Test
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testUnrelatedListObjects() {

        final List list = new ArrayList();
        list.add("2");
        list.add(3);
        list.add(null);

        log.info("list: {}", list);
    }

}
