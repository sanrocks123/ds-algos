/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.repositories;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

            final ProcessBuilder pb = new ProcessBuilder("/usr/local/gradle-app/devops/hello.sh");
            pb.environment().put("USERS", "saxena@MSAD.MS.COM, raaashi@MSAD.MS.COM");
            pb.environment().put("ES_URL", "http://hello:8080");

            pb.redirectOutput(new File("/usr/local/gradle-app/process.output"));

            final Process p = pb.start();
            while (p.isAlive()) {
                log.info("script still running, please wait");
                TimeUnit.SECONDS.sleep(5);
            }

            if (p.exitValue() == 0) {
                log.info("Great ! script executed, status ok");
            }
        }
        catch (final IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
