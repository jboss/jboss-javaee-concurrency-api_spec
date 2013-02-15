package javax.enterprise.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 */
public interface ManagedScheduledExecutorService extends ManagedExecutorService, ScheduledExecutorService {
    <V> ScheduledFuture<V> schedule(Callable<V> callable, Trigger trigger);

    ScheduledFuture<?> schedule(Runnable command, Trigger trigger);
}
