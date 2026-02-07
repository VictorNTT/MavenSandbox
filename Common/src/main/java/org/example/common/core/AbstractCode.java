package org.example.common.core;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCode {
    private static final Map<Class<? extends AbstractCode>, Map<Integer, ? extends AbstractCode>> codeRepo = new HashMap<>();
    private short ordinal;
    private String description;


    protected AbstractCode(final short ordinal, final String description) {
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
            codes.put((int) ordinal, this);
        }
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(short ordinal) {
        this.ordinal = ordinal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
