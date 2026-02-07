package org.example.common.core;

@DeltaEntities (classes = MQConfig.class)
public class MQConfig extends AbstractFeedHubConfig {

    private String user;
    private String host;
    private int port;
    private String queueManager;
    private String channel;
    private String sendQueueName;
    private String receiveQueueName;
    private MQType mqType;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public ConnectionType getConnectionType() {
        return ConnectionType.MQ;
    }

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String topic() {
        return null;
    }

    @Override
    public String getConverterClass() {
        return null;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getQueueManager() {
        return queueManager;
    }

    public void setQueueManager(String queueManager) {
        this.queueManager = queueManager;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSendQueueName() {
        return sendQueueName;
    }

    public void setSendQueueName(String sendQueueName) {
        this.sendQueueName = sendQueueName;
    }

    public String getReceiveQueueName() {
        return receiveQueueName;
    }

    public void setReceiveQueueName(String receiveQueueName) {
        this.receiveQueueName = receiveQueueName;
    }

    public MQType getMqType() {
        return mqType;
    }

    public void setMqType(MQType mqType) {
        this.mqType = mqType;
    }

    @Override
    public String getDBPrimaryKey() {
        return sourceSystem();
    }
}
