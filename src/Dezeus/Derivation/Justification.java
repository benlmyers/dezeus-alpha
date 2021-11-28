package Dezeus.Derivation;

public class Justification {
    
    String abbreviation;

    public Justification(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String toString() {
        if(abbreviation == null) {
            return "None";
        } else {
            return abbreviation;
        }
    }
}
