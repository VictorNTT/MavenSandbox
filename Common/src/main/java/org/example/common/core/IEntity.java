package org.example.common.core;

public interface IEntity extends Cloneable {
    String getPrimaryKey();
    IVersionable cloneObject();

}
