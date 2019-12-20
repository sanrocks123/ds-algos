/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.repositories;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import sanrockzz.gradledemo.dto.Tag;

/**
 * Java Source TaggingRepository.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@Repository
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaggingRepository {

    /**
     *
     * @param tag
     * @return
     */
    public Tag create(final Tag tag) {
        return new Tag("default-tag");
    }

}
