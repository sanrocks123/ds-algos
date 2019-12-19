/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrocks.designpatterns;

/**
 * Java Source OverloadingOverridingClass.java created on Dec 2, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class OverloadingOverridingClass {

    private String name;

    public String formatName(String name) {
        return String.format("Helo-%s", name);
    }

    public String formatName(String name, int a) {
        return String.format("Helo-%s", name);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    private void display() {
        System.out.println("A");
    }

}
