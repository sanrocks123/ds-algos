/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package test.interview.overriding;

/**
 * Java Source InterfaceB.java created on Dec 18, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface InterfaceB {

    default void print() {
        System.out.println("Interface B");
    }

}
