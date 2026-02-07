package org.example.common.core;

public class MQType extends AbstractCode {

    public static final MQType IBM = new MQType((byte)1, "IBM");
    public static final MQType OTHER = new MQType((byte)2, "OTHER");

    protected MQType(short ordinal, String description) {
        super(ordinal, description);
    }
}
