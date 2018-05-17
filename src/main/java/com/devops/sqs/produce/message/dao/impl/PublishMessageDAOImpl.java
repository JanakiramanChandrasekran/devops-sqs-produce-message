package com.devops.sqs.produce.message.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.devops.sqs.produce.message.dao.PublishMessageDAO;
import com.devops.sqs.produce.message.model.Message;

/**
 * @since 1.0
 */
@Named
public class PublishMessageDAOImpl implements PublishMessageDAO {

    private final AmazonSQS amazonSQS;

    private final String queueURL;

    @Inject
    public PublishMessageDAOImpl(final AmazonSQS amazonSQS, @Value("${queue.name}") final String queueName) {
        this.amazonSQS = amazonSQS;
        this.queueURL = amazonSQS.getQueueUrl(queueName).getQueueUrl();
    }

    public void publishMessage(final Message message) {
        amazonSQS.sendMessage(new SendMessageRequest(queueURL, message.getMessage()));
    }

}
