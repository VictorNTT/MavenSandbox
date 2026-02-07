package org.example.common.core;

public interface IDBEntity {
    String getDBPrimaryKey();
    IDBEntity cloneObject() throws CloneNotSupportedException;
}
