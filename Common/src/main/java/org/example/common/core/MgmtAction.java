package org.example.common.core;

public class MgmtAction extends AbstractCode {
    // managing message lifecycle
    public static final MgmtAction NEW = new MgmtAction((byte)1, "NEW");
    public static final MgmtAction DELETE = new MgmtAction((byte)2, "DELETE");
    public static final MgmtAction UPDATE = new MgmtAction((byte)3, "UPDATE");
    public static final MgmtAction HISTORY = new MgmtAction((byte)4, "HISTORY");

    protected MgmtAction(short ordinal, String description) {
        super(ordinal, description);
    }
}
