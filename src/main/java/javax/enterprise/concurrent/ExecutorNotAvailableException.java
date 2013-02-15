package javax.enterprise.concurrent;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

/**
 */
public class ExecutorNotAvailableException extends ExecutionException implements Serializable {

    private static final long serialVersionUID = -5383397667254815571L;

    public ExecutorNotAvailableException() {
    }

    public ExecutorNotAvailableException(final String msg) {
        super(msg);
    }

    public ExecutorNotAvailableException(final Throwable cause) {
        super(cause);
    }

    public ExecutorNotAvailableException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
