/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.dto;

import org.json.JSONObject;

/**
 * Java Source Tag.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class Tag {

    private String name;

    /**
     * @param string
     */
    public Tag(String name) {
        this.name = name;
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
    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }

}
