/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanrockzz.gradledemo.dto.Tag;
import sanrockzz.gradledemo.repositories.TaggingRepository;

/**
 * Java Source TaggingServiceImpl.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@Service
public class TaggingServiceImpl implements TaggingService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaggingRepository tagRepo;

    /*
     * (non-Javadoc)
     *
     * @see
     * sanrockzz.gradledemo.service.TaggingService#create(sanrockzz.gradledemo.
     * dto.Tag)
     */
    @Override
    public Tag create(Tag tag) {
        log.info("tagRepos hashCode: {}", tagRepo.hashCode());
        return tagRepo.create(tag);
    }

}
