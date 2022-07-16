/**
 * Copyright (c) 2019 @SanRockzz Ltd. All Rights Reserved.
 */

package sanrockzz.gradledemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sanrockzz.gradledemo.dto.Tag;
import sanrockzz.gradledemo.service.TaggingService;

/**
 * Java Source TaggingController.java created on Dec 20, 2019
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */

@Slf4j
@RestController
@RequestMapping(value = "/v1/tag", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaggingController {

    @Autowired
    private TaggingService tagService;

    /**
     * @param tag
     * @return
     */
    @Operation(summary = "Create new tag resource object")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "New tag resource created", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Tag.class))}),
        @ApiResponse(responseCode = "400", description = "something is wrong tag request payload", content = @Content)})
    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        return new ResponseEntity<Tag>(tagService.create(tag), HttpStatus.CREATED);
    }

    /**
     * @param pageable
     * @return
     */
    @Operation(summary = "API to list tags")
    @GetMapping("/list")
    public ResponseEntity<List<Tag>> list(@ParameterObject Pageable pageable) {
        log.info("list, pageable: {}", pageable);
        return ResponseEntity.ok(Arrays.asList(new Tag("1"), new Tag("2")));
    }
}
