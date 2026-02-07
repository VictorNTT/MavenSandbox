package org.example.common.core;

public interface IMgmtEntity extends IDBEntity {
    MgmtAction getAction();
    void setAction(MgmtAction action);
}
