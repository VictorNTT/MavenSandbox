package org.example.common.core;

public abstract class AbstractFeedHubConfig extends AbstractMgmtEntity implements IDBEntityDelta, IDisablable {
    private String sourceSystem;
    private boolean disabled;


    public abstract ConnectionType getConnectionType();
    public abstract String getHost();
    public abstract int getPort();

    /** source system which the data comes from */
    public abstract String sourceSystem();
    /** topic name which the data will be saved to */
    public abstract String topic();

    /** FQN of the class that will convert the data on receiving */
    public abstract String getConverterClass();

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }
}
