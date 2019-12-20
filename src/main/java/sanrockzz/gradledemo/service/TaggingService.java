/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.service;

import sanrockzz.gradledemo.dto.Tag;

/**
 * Java Source TaggingService.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public interface TaggingService {

    /**
     * creates new tag
     *
     * @param tag
     * @return
     */
    public Tag create(final Tag tag);

}
