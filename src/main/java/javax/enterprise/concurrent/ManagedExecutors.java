package javax.enterprise.concurrent;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 */
public final class ManagedExecutors {
    private ManagedExecutors() {}

    public static boolean isCurrentThreadShutdown() {
        final Thread thread = Thread.currentThread();
        return thread instanceof ManageableThread && ((ManageableThread)thread).isShutdown();
    }

    public static <V> Callable<V> managedTask(Callable<V> task, ManagedTaskListener taskListener) {
        return new ManagedCallable<V>(task, taskListener, null);
    }

    public static <V> Callable<V> managedTask(Callable<V> task, Map<String, String> executionProperties, ManagedTaskListener taskListener) {
        return new ManagedCallable<V>(task, taskListener, executionProperties);
    }

    static class ManagedCallable<V> implements Callable<V>, ManagedTask {
        private final Callable<V> task;
        private final ManagedTaskListener taskListener;
        private final Map<String, String> executionProperties;

        ManagedCallable(final Callable<V> task, final ManagedTaskListener taskListener, final Map<String, String> executionProperties) {
            this.task = task;
            this.taskListener = taskListener;
            this.executionProperties = executionProperties;
        }

        public V call() throws Exception {
            return task.call();
        }

        public Map<String, String> getExecutionProperties() {
            return executionProperties;
        }

        public String getIdentityDescription(final Locale locale) {
            return "anonymous";
        }

        public ManagedTaskListener getManagedTaskListener() {
            return taskListener;
        }
    }

    public static Runnable managedTask(Runnable task, ManagedTaskListener taskListener) {
        return new ManagedRunnable(task, taskListener, null);
    }

    public static Runnable managedTask(Runnable task, Map<String, String> executionProperties, ManagedTaskListener taskListener) {
        return new ManagedRunnable(task, taskListener, executionProperties);
    }

    static class ManagedRunnable implements Runnable, ManagedTask {
        private final Runnable task;
        private final ManagedTaskListener taskListener;
        private final Map<String, String> executionProperties;

        ManagedRunnable(final Runnable task, final ManagedTaskListener taskListener, final Map<String, String> executionProperties) {
            this.task = task;
            this.taskListener = taskListener;
            this.executionProperties = executionProperties;
        }

        public void run() {
            task.run();
        }

        public Map<String, String> getExecutionProperties() {
            return executionProperties;
        }

        public String getIdentityDescription(final Locale locale) {
            return "anonymous";
        }

        public ManagedTaskListener getManagedTaskListener() {
            return taskListener;
        }
    }
}
