package javax.enterprise.concurrent;

import java.util.Locale;
import java.util.Map;

/**
 */
public interface ManagedTask {
    String CONTEXTUAL_CALLBACK_UNIT = "javax.enterprise.concurrent.CONTEXTUAL_CALLBACK_HINT";
    String DISTRIBUTABLE_HINT = "javax.enterprise.concurrent.DISTRIBUTABLE_HINT";
    String IDENTITY_NAME = "javax.enterprise.concurrent.IDENTITY_NAME";
    String LONGRUNNING_HINT = "javax.enterprise.concurrent.LONGRUNNING_HINT";

    Map<String, String> getExecutionProperties();

    String getIdentityDescription(Locale locale);

    ManagedTaskListener getManagedTaskListener();
}
