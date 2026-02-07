package org.example.common.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeltaEntities {
    public abstract Class<? extends IDBEntityDelta> classes();
}
