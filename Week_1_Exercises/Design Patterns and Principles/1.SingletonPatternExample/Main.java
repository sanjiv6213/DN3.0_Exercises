import java.util.Date;

enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARNING(4),
    ERROR(5);

    final int level;

    LogLevel(int level) {
        this.level = level;
    }
}

class Logger {
    private static Logger instance;
    private LogLevel logLevel;

    // constructor
    private Logger() {
        logLevel = LogLevel.INFO;
    }

    public static Logger getInstance() {
        if (instance == null) {
            System.out.println("instance is null");
            instance = new Logger();
            return instance;
        }

        return instance;
    }

    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public void log(LogLevel level, String message) {
        if (logLevel.ordinal() <= level.ordinal()) {
            String logMessage = "[" + new Date() + "] [" + level + "] " + message;
            System.out.println(logMessage);
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Logger logger_1 = Logger.getInstance();
        Logger logger_2 = Logger.getInstance();

        logger_1.log(LogLevel.WARNING, "This is a warning log statement");
        logger_2.log(LogLevel.ERROR, "This is a error log statement");
        logger_1.log(LogLevel.INFO, "This is a Info Log statement");

        if (logger_1.hashCode() == logger_2.hashCode()) {
            System.out.println("Same instance is being used");
        } else {
            System.out.println("Different Instances are being used");
        }
    }
}