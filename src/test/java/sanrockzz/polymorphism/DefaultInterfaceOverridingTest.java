/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.polymorphism;

import org.junit.Test;

class A {

    public A(int i) {
    }

    protected void display() throws NullPointerException {
        System.out.println("A");
    }
}

class B extends A implements AA, BB {

    /**
     * @param i
     */
    public B(int i) {
        super(12);
    }

    @Override
    public void defaultPrintMethod() {
        BB.super.defaultPrintMethod();
    }

    @Override
    public void displaySAM() {
        // TODO Auto-generated method stub
    }

}

interface AA {

    default void defaultPrintMethod() {
        System.out.println("Interface A");
    }

    abstract void displaySAM();

}

interface BB {

    default void defaultPrintMethod() {
        System.out.println("Interface B");
    }

    abstract void displaySAM();

}

public class DefaultInterfaceOverridingTest {

    @Test
    public void test() {
        final A a = new B(100);
        a.display();
    }

}
