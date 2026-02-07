package org.example.common.core;

import java.util.Date;

public interface IChangeable extends IVersionable {
    Date getLastModTime();
    void setLastModTime(Date lastModTime);
}
