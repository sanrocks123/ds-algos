/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import sanrockzz.gradledemo.dto.Tag;
import sanrockzz.gradledemo.service.TaggingService;

/**
 * Java Source TaggingController.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

@RestController
@Api(value = "Tagging Service")
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaggingController {

    @Autowired
    private TaggingService tagService;

    @PostMapping("/tag")
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        return new ResponseEntity<Tag>(tagService.create(tag), HttpStatus.CREATED);
    }

}
