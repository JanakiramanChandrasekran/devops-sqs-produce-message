package com.devops.sqs.produce.message.dao;

import com.devops.sqs.produce.message.model.Message;

/**
 * @since 1.0
 */
public interface PublishMessageDAO {

    void publishMessage(final Message message);

}
