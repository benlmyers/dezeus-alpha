package Dezeus.Core;

public class Logger {

    private Logger() {
    }

    public static void log(Show show) {
        System.out.println("Show " + show.toString());
    }

    public static void log(Proposition proposition) {
        System.out.println("Proving Proposition " + proposition.getNumber());
    }

    public static void log(Truth truth) {
        System.out.println("Valid: " + truth.toString());
    }
}
