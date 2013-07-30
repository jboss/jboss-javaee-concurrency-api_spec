package javax.enterprise.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 */
public class ManagedExecutors {
    private ManagedExecutors() {}

    public static boolean isCurrentThreadShutdown() {
        Thread thread = Thread.currentThread();
        return thread instanceof ManageableThread && ((ManageableThread)thread).isShutdown();
    }

    public static <V> Callable<V> managedTask(Callable<V> task, ManagedTaskListener taskListener) throws IllegalArgumentException {
        return new ManagedCallable<V>(task, taskListener, null);
    }

    public static <V> Callable<V> managedTask(Callable<V> task, Map<String, String> executionProperties, ManagedTaskListener taskListener) throws IllegalArgumentException {
        return new ManagedCallable<V>(task, taskListener, executionProperties);
    }

    static class ManagedCallable<V> extends AbstractManagedTask implements Callable<V> {
        private Callable<V> task;

        ManagedCallable(Callable<V> task, ManagedTaskListener taskListener, Map<String, String> executionProperties) {
            super(task, taskListener, executionProperties);
            this.task = task;
        }

        public V call() throws Exception {
            return task.call();
        }
    }

    public static Runnable managedTask(Runnable task, ManagedTaskListener taskListener) throws IllegalArgumentException {
        return new ManagedRunnable(task, taskListener, null);
    }

    public static Runnable managedTask(Runnable task, Map<String, String> executionProperties, ManagedTaskListener taskListener) throws IllegalArgumentException {
        return new ManagedRunnable(task, taskListener, executionProperties);
    }

    static class ManagedRunnable extends AbstractManagedTask implements Runnable {
        private Runnable task;

        ManagedRunnable(Runnable task, ManagedTaskListener taskListener, Map<String, String> executionProperties) {
            super(task, taskListener, executionProperties);
            this.task = task;
        }

        public void run() {
            task.run();
        }
    }

    abstract static class AbstractManagedTask implements ManagedTask {
        private ManagedTaskListener taskListener;
        private Map<String, String> executionProperties = null;

        AbstractManagedTask(Object task, ManagedTaskListener taskListener, Map<String, String> executionProperties) throws IllegalArgumentException {
            if (task == null) {
                throw new IllegalArgumentException("null task");
            }
            ManagedTask managedTask = task instanceof ManagedTask ? (ManagedTask) task : null;
            if (taskListener != null) {
                this.taskListener = taskListener;
            } else {
                this.taskListener = managedTask != null ? managedTask.getManagedTaskListener() : null;
            }
            if (managedTask != null && managedTask.getExecutionProperties() != null) {
                this.executionProperties = new HashMap<String, String>(managedTask.getExecutionProperties());
            }
            if (executionProperties != null) {
                if (this.executionProperties == null) {
                    this.executionProperties = new HashMap<String, String>(executionProperties);
                } else {
                    this.executionProperties.putAll(executionProperties);
                }
            }
        }

        @Override
        public Map<String, String> getExecutionProperties() {
            return executionProperties;
        }

        @Override
        public ManagedTaskListener getManagedTaskListener() {
            return taskListener;
        }
    }
}
