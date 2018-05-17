package com.devops.sqs.produce.message.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @since 1.0
 */

public class Message implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4611370633033537983L;

    private String receivedDateTime;

    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the receivedDateTime
     */
    public String getReceivedDateTime() {
        return receivedDateTime;
    }

    /**
     * @param receivedDateTime the receivedDateTime to set
     */
    public void setReceivedDateTime(String receivedDateTime) {
        this.receivedDateTime = receivedDateTime;
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}