package com.smash.ladder.aws

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.stereotype.Service

@Service
class AWSConfig {

    // Initializes AWS Credentials variable using env variables
    private BasicAWSCredentials awsCredentials = new BasicAWSCredentials(
            System.getenv("access_key_id"),
            System.getenv("secret_key_id"))

    // Creates AmazonS3 client connection
    AmazonS3 amazonS3 () {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build()
    }

    // Creates Amazon DynamoDB client connection
    AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build()
    }

}
