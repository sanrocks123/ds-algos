/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package test.interview.overriding;

import org.junit.Test;

/**
 * Java Source OverridingTest.java created on Dec 12, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class OverridingTest {

    @Test
    public void test() {
        final BaseA a = new B();
        a.display();
    }

}
