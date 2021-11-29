package Dezeus.Derivation;

public class Justification {

    private String full, abbreviation;

    public Justification(String full, String abbreviation) {
        this.full = full;
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        if (abbreviation == null) {
            return "None";
        } else {
            return abbreviation;
        }
    }

    public String toString() {
        if (abbreviation == null) {
            return "NA";
        } else {
            return full;
        }
    }
}
