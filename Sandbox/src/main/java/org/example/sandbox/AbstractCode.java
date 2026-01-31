package org.example.sandbox;

public class AbstractCode {
    private int ordinal;
    private String description;

    public AbstractCode() {}

    public AbstractCode(int ordinal, String description) {
        this.ordinal = ordinal;
        this.description = description;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
