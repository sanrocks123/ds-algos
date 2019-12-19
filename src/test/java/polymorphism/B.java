/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package polymorphism;

/**
 * Java Source B.java created on Dec 12, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class B extends BaseA implements InterfaceA, InterfaceB {

    /**
     * @param i
     */
    public B(int i) {
        // TODO Auto-generated constructor stub
    }

    protected B() {
        this(12);
    }

    /*
     * (non-Javadoc)
     *
     * @see test.interview.overriding.InterfaceA#aa()
     */
    @Override
    public void aa() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see test.interview.overriding.InterfaceB#print()
     */
    @Override
    public void print() {
        // TODO Auto-generated method stub
        InterfaceB.super.print();
    }

    /**
     *
     */
    @Override
    protected void display() throws IllegalArgumentException {
        System.out.println("B");
        InterfaceA.super.print();
    }
}
