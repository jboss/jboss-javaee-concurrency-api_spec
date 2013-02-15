package javax.enterprise.concurrent;

import java.util.Date;

/**
 */
public interface LastExecution {
    String getIdentityName();

    Object getResult();

    Date getRunEnd();

    Date getRunStart();

    Date getScheduledStart();
}
