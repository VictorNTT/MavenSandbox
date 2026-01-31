package org.example.sandbox;

public record MQConnection(String host, int port, String mqr, String channel, String userId) {
    // Record contains all properties for an MQ connection
    // Fields are initialized at constructor once only and no change.
}
