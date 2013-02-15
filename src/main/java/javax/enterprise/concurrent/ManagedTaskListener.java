package javax.enterprise.concurrent;

import java.util.concurrent.Future;

/**
 */
public interface ManagedTaskListener {
    void taskAborted(Future<?> future, ManagedExecutorService executor, Throwable exception);

    void taskDone(Future<?> future, ManagedExecutorService executor, Throwable exception);

    void taskStarting(Future<?> future, ManagedExecutorService executor);

    void taskSubmitted(Future<?> future, ManagedExecutorService executor);
}
