package logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getInstance();

        logger.write("First log message");
        logger.write("Test messasge");
        logger.close();
    }
}
