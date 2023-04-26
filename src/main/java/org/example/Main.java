import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }
}
