package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import utilities.Logs;

import java.util.Optional;

public class ResultListeners implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Logs.info("Test Disabled: %s",context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Logs.info("Test Successful: %s", context.getDisplayName());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Logs.info("Test Aborted: %s",context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Logs.info("Test Failed: %s", context.getDisplayName());
    }
}
