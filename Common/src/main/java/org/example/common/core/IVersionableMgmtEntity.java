package org.example.common.core;

public interface IVersionableMgmtEntity extends IMgmtEntity, IChangeable {
    String getLastModUser();
    void setLastModUser(String user);
}
