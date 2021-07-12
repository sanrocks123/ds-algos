/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.oops;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source StringManipulationTest.java created on Dec 23, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class StringManipulationTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testHashMap() {
        final String s1 = "Sanjeev";
        final String s2 = new String("Sanjeev");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1 == s2);

        final Map<String, String> map = new HashMap<>();
        map.put(s1, "s1");
        map.put(s2, "s2");

        System.out.println(map);
    }

    @Test
    public void testIntern() {

        // final String s1 = new String("Hello");
        final String s2 = new String("World");

        final String s3 = s2.intern();

        log.info("s3: {}", s3);
        Assert.assertFalse(s3 == s2);

        Assert.assertTrue(s3 == s2.intern());
        Assert.assertTrue("World" == s2.intern());
    }

    @Test
    public void testStringObjectNull() {
        new StringManipulationTest().hello(null);
        new StringManipulationTest().hello((Object) null);
    }

    @Test
    public void testSystemOverloading() {
        final String str = null;
        System.out.println(null + str);
        System.out.println(str + null);
    }

    /**
     * @param object
     */
    private void hello(Object object) {
        log.debug("object: {}", object);

    }

    /**
     * @param object
     */
    private void hello(String str) {
        log.debug("str: {}", str);

    }
}
