package org.example.common.core;

public class ConnectionType extends AbstractCode {

    public static final ConnectionType MQ = new ConnectionType((byte)1, "MQ");
    public static final ConnectionType SFTP = new ConnectionType((byte)2, "SFTP");
    public static final ConnectionType KAFKA = new ConnectionType((byte)3, "KAFKA");
    public static final ConnectionType FIX = new ConnectionType((byte)4, "FIX");
    public static final ConnectionType SOLACE = new ConnectionType((byte)5, "SOLACE");
    public static final ConnectionType REST = new ConnectionType((byte)6, "REST");

    protected ConnectionType(short ordinal, String description) {
        super(ordinal, description);
    }
}
