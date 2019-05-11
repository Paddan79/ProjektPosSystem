package se.kth.iv1350.pocesSale.LogHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is responsible for the log.
 *
 * could be called filelogger.
 *
 * Singleton
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "POS-log.txt";
    private PrintWriter logFile;
    private static final LogHandler LOG_HANDLER;

    static {
        LogHandler tmp = null;
        try {
            tmp = new LogHandler();
        } catch (IOException e) {
            tmp.logException(e);
        }
        LOG_HANDLER = tmp;
    }


    private LogHandler() throws IOException {
       logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }

    public static LogHandler getLogger(){
        return LOG_HANDLER;
    }

    /**
     * Writes a log entry describing a thrown exception.
     *
     * @param exception The exception that shall be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTimeStamp());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }

    private String createTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}