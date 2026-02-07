package org.example.common.core;

public abstract class AbstractMgmtEntity extends AbstractMsg implements IVersionableMgmtEntity {
    private MgmtAction action;

    public AbstractMgmtEntity() {
        action = MgmtAction.NEW;
    }

    @Override
    public MgmtAction getAction() {
        return this.action;
    }

    @Override
    public void setAction(MgmtAction action) {
        this.action = action;
    }

    @Override
    public AbstractMgmtEntity cloneObject() throws CloneNotSupportedException {
        return (AbstractMgmtEntity) clone();
    }
}
