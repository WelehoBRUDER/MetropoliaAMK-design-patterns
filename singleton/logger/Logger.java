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

    public void setFileName(String fileName) {
        if (isOpen) {
            try {
                close();
            }
            catch (IOException e) {
                System.out.println("Could not close file: " + this.fileName);
            }
        }
        this.fileName = fileName;
        isOpen = true;
        try {
            fw = new FileWriter(fileName, true);
        }
        catch (IOException e) {
            System.out.println("Could not open/create file: " + this.fileName);
        }
    }

    public void write(String message) {
        System.out.println("Writing to " + fileName + ": " + message);
        try {
            fw.write(message + "\n");
        }
        catch (IOException e) {
            System.out.println("Could not write to file: " + fileName);
        }
    }

    public void close() throws IOException {
        System.out.println("Closing logger for file: " + fileName);
        fw.close();
    }
}
