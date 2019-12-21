/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.oops;

import java.util.ArrayList;
import java.util.List;

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
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testUnrelatedListObjects() {

        final List list = new ArrayList();
        list.add("2");
        list.add(3);

        log.info("list: {}", list);
    }

}
