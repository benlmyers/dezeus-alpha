package Dezeus.Core;

public class Logger {

    private static int titleRowLength = 24;

    protected Logger() {
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void line() {
        String line = "";
        for(int i = 0; i < titleRowLength; i++) {
            line += "-";
        }
        log(line);
    }

    public static void title(String title) {
        log("----------[ " + title + " ]----------");
        titleRowLength = title.length() + 24;
    }

    public static void log(Show show) {
        log(show.toString() + logicalSizeString(show.getStatement()));
    }

    public static void log(Proposition proposition) {
        log("Proving " + proposition + logicalSizeString(proposition.getStatement()));
    }

    public static void log(Truth truth) {
        log("Valid: " + truth.toString());
    }

    private static String logicalSizeString(Statement statement) {
        return " \t\t[" + statement.logicalSize() + "]";
    }
}
