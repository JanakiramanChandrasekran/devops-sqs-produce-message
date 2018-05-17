package com.devops.sqs.produce.message.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

/**
 * Connection Factory to load the SQS Configuration
 * 
 * @since 1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ConfigurationFactory {

    /**
     * Create the AWSCredentials with the provided details
     * 
     * @param accessKey
     * @param secretKey
     * @param securityToken
     * @return
     */
    @Bean
    public AWSCredentialsProvider awsCredentials(@Value("${aws.access.key}") final String accessKey,
            @Value("${aws.secret.key}") final String secretKey,
            @Value("${aws.security.token}") final String securityToken) {
        return new AWSStaticCredentialsProvider(new BasicSessionCredentials(accessKey, secretKey, securityToken));
    }

    /**
     * Create the client configuration to reuse on required injections
     * 
     * @param proxyHost
     * @param proxyPort
     * @param proxyUser
     * @param proxyPassword
     * @return
     */
    @Bean
    public ClientConfiguration clientConfiguration(@Value("${proxy.host}") final String proxyHost,
            @Value("${proxy.port}") final int proxyPort, @Value("${proxy.user}") final String proxyUser,
            @Value("${proxy.password}") final String proxyPassword) {
        final ClientConfiguration configuration = new ClientConfiguration();
        configuration.setProtocol(Protocol.HTTPS);
        configuration.setProxyHost(proxyHost);
        configuration.setProxyPort(proxyPort);
        configuration.setProxyUsername(proxyUser);
        configuration.setProxyPassword(proxyPassword);
        return configuration;
    }

    /**
     * Initiate the {@link AmazonSQS}
     * 
     * @param clientConfiguration
     * @param awsCredentials
     * @param region
     * @return
     */
    @Bean
    public AmazonSQS amazonSQSClient(final ClientConfiguration clientConfiguration,
            final AWSCredentialsProvider awsCredentials, @Value("${aws.region}") final String region) {
        return AmazonSQSClientBuilder.standard().withRegion(region).withClientConfiguration(clientConfiguration)
                .withCredentials(awsCredentials).build();
    }
}