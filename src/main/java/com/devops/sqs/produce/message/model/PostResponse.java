package com.devops.sqs.produce.message.model;

import java.io.Serializable;

/**
 * @since 1.0
 */
public class PostResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6326008412019437551L;

    private final boolean isSuccess;

    /**
     * @param isSuccess
     */
    public PostResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * @return the isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }

}