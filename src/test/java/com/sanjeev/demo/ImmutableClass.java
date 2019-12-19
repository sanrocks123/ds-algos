package com.sanjeev.demo;

/**
 *
 * Java Source ImmutableClass.java created on Dec 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

class ExtendedImmutableClass extends ImmutableClass {
    int overrideId;

    public ExtendedImmutableClass(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return this.overrideId;
    }

    public Integer printVal(Integer arg) {
        return arg;
    }

    public Object printVal(Object arg) {
        return arg;
    }

    public String printVal(String arg) {
        return arg;
    }

    public void setId(int id) {
        this.overrideId = id;
    }

}

class ImmutableClass {
    final int id;

    public ImmutableClass(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
