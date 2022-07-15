/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.dto;

import java.io.Serializable;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.json.JSONObject;

/**
 * Java Source Tag.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */

public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 0, max = 20)
    private String name;
    private String id;

    /**
     *
     */
    public Tag() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * @param string
     */
    public Tag(String name) {
        this();
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
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
