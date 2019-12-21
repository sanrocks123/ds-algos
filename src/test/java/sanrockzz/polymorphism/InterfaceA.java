/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.polymorphism;

/**
 * Java Source InterfaceA.java created on Dec 18, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface InterfaceA {

    abstract void aa();

    default void print() {
        System.out.println("Interface A");
    }

}
