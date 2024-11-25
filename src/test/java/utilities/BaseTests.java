package utilities;

import listeners.ResultListeners;
import listeners.TestListeners;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ResultListeners.class, TestListeners.class})
public class BaseTests {

    @BeforeEach
    void setUp() {
        Logs.info("Parent Setup");
    }

    @AfterEach
    void tearDown() {
        Logs.info("Parent Tear Down");
    }
}
