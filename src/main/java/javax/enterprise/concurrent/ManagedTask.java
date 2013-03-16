package javax.enterprise.concurrent;

import java.util.Locale;
import java.util.Map;

/**
 */
public interface ManagedTask {
    String IDENTITY_NAME = "javax.enterprise.concurrent.IDENTITY_NAME";
    String LONGRUNNING_HINT = "javax.enterprise.concurrent.LONGRUNNING_HINT";
    String SUSPEND = "SUSPEND";
    String TRANSACTION = "javax.enterprise.concurrent.TRANSACTION";
    String USE_TRANSACTION_OF_EXECUTION_THREAD = "USE_TRANSACTION_OF_EXECUTION_THREAD";

    Map<String, String> getExecutionProperties();

    ManagedTaskListener getManagedTaskListener();
}
