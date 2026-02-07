package org.example.common.core;

import java.util.Date;

public abstract class AbstractMsg implements IVersionable {

    private int version;
    private String sysmsg;
    private String lastModUser;
    private Date lastModTime;

    @Override
    public int getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    public String getSysmsg() {
        return sysmsg;
    }

    public void setSysmsg(String sysmsg) {
        this.sysmsg = sysmsg;
    }

    public String getLastModUser() {
        return lastModUser;
    }

    public void setLastModUser(String lastModUser) {
        this.lastModUser = lastModUser;
    }

    public Date getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Date lastModTime) {
        this.lastModTime = lastModTime;
    }

    @Override
    public AbstractMsg clone() throws CloneNotSupportedException {
        return (AbstractMsg) super.clone();
    }
}
