package com.dilfer.aws.lambda;

public class UpdateRequestParams
{
    private String sqsUrl;
    private String dynamoTableName;

    public UpdateRequestParams() {
    }

    public String getSqsUrl() {
        return sqsUrl;
    }

    public void setSqsUrl(String sqsUrl) {
        this.sqsUrl = sqsUrl;
    }

    public String getDynamoTableName() {
        return dynamoTableName;
    }

    public void setDynamoTableName(String dynamoTableName) {
        this.dynamoTableName = dynamoTableName;
    }
}
