package bll;

import javax.security.auth.Subject;

public abstract class Observable {
    protected Subject subiect;
    public abstract void update();
}
