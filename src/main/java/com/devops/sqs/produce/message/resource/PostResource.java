package com.devops.sqs.produce.message.resource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devops.sqs.produce.message.dao.PublishMessageDAO;
import com.devops.sqs.produce.message.model.Message;
import com.devops.sqs.produce.message.model.PostResponse;

/**
 * @since 1.0
 */
@Named
@Singleton
@RequestMapping("/devops-sqs-produce-app/message")
@RestController
public class PostResource {

    @Inject
    private PublishMessageDAO publishMessageDAO;

    private final PostResponse response = new PostResponse(Boolean.TRUE);

    /**
     * Insert the message into the db
     * 
     * @param messagePayload
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PostResponse> insertMessage(@RequestBody final Message message) {
        publishMessageDAO.publishMessage(message);
        return new ResponseEntity<PostResponse>(response, HttpStatus.CREATED);
    }

}
