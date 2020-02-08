/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.repositories;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     *
     * @param tag
     * @return
     */
    public Tag create(final Tag tag) {
        doExecuteScript();
        return new Tag("default-tag");
    }

    /**
     * 
     */
    private void doExecuteScript() {
        try {
            final Process p = Runtime.getRuntime().exec("/usr/local/gradle-app/devops/helllo.sh");
            while (p.isAlive()) {
            }
            if (p.exitValue() == 0) {
                log.info("hello.sh executed normally");
            }
        }
        catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
