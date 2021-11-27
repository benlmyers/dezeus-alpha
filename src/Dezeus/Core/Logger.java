package Dezeus.Core;

public class Logger {

    private Logger() {
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void line() {
        log("------------------------");
    }

    public static void title(String title) {
        log("------[" + title + "]------");
    }

    public static void log(Show show) {
        log("Show " + show.toString() + "[" + show.getStatement().logicalSize() + "]");
    }

    public static void log(Proposition proposition) {
        log("Proving Proposition " + proposition.getNumber());
    }

    public static void log(Truth truth) {
        log("Valid: " + truth.toString());
    }
}
