package javax.enterprise.concurrent;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

/**
 */
public class SkippedException extends ExecutionException implements Serializable {

    private static final long serialVersionUID = 6296866815328432550L;

    public SkippedException() {
    }

    public SkippedException(final String msg) {
        super(msg);
    }

    public SkippedException(final Throwable cause) {
        super(cause);
    }

    public SkippedException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
