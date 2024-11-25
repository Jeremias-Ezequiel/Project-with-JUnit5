package listeners;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import utilities.Logs;

public class TestListeners implements AfterEachCallback, BeforeEachCallback {
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Logs.info("After each: %s", context.getDisplayName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Logs.info("Before each: %s", context.getDisplayName());
    }
}
