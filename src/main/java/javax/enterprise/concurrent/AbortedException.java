package javax.enterprise.concurrent;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

/**
 */
public class AbortedException extends ExecutionException implements Serializable {

    private static final long serialVersionUID = -8248124070283019190L;

    public AbortedException() {
    }

    public AbortedException(final String msg) {
        super(msg);
    }

    public AbortedException(final Throwable cause) {
        super(cause);
    }

    public AbortedException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
