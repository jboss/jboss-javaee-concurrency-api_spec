package javax.enterprise.concurrent;

import java.util.concurrent.Future;

/**
 */
public interface ManagedTaskListener {
    void taskAborted(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception);

    void taskDone(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception);

    void taskStarting(Future<?> future, ManagedExecutorService executor, Object task);

    void taskSubmitted(Future<?> future, ManagedExecutorService executor, Object task);
}
