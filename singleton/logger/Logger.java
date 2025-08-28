package logger;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter fw;
    private String fileName;
    private Boolean isOpen = false;

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public Logger() {
        this.fileName = "new_log.txt";
        try {
            fw = new FileWriter(fileName, true);
            isOpen = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String fileName) throws IOException {
        if (isOpen) {
            close();
        }
        this.fileName = fileName;
        isOpen = true;
        fw = new FileWriter(fileName, true);
    }

    public void write(String message) throws IOException {
        System.out.println("Writing to " + fileName + ": " + message);
        fw.write(message + "\n");
    }

    public void close() throws IOException {
        System.out.println("Closing logger for file: " + fileName);
        fw.close();
    }
}
