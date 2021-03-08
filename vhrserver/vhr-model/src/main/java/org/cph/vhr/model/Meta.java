package org.cph.vhr.model;

import java.io.Serializable;

public class Meta implements Serializable {
    private static final long serialVersionUID = 4781396522567636429L;

    private Boolean keepAlive;

    private Boolean requireAuth;

    @Override
    public String toString() {
        return "Meta{" +
                "keepAlive=" + keepAlive +
                ", requireAuth=" + requireAuth +
                '}';
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
