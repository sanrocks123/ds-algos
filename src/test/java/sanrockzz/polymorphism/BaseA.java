/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.polymorphism;

/**
 * Java Source A.java created on Dec 12, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class BaseA {

    /**
     * @param i
     */
    public BaseA(int i) {
        // TODO Auto-generated constructor stub
    }

    protected BaseA() {
    }

    /**
     *
     * @param a
     */
    protected void display() throws NullPointerException {
        System.out.println("A");
    }
}
