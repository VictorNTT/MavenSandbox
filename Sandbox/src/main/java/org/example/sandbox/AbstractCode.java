package org.example.sandbox;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCode {
    private static final Map<Class<? extends AbstractCode>, Map<Integer, ? extends AbstractCode>> codeRepo = new HashMap<>();
    private int ordinal;
    private String description;


    protected AbstractCode(final int ordinal, final String description) {
        this.ordinal = ordinal;
        this.description = description;

        synchronized (codeRepo) {
            Map<Integer, AbstractCode> codes = (Map<Integer, AbstractCode>) codeRepo.get(this.getClass());
            if(codes == null) {
                codes = new HashMap<>();
                codeRepo.put(this.getClass(), codes);
            }

            // check for dup key -- don't allow ordinal to be duplicated

            if(codes.containsKey(ordinal))
                throw new RuntimeException("Duplicate ordinal: "+ordinal+", description: " +description+ ", of type: " + this.getClass().getSimpleName());
            codes.put(ordinal, this);
        }
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
