package Dezeus.Core;

public class Variable extends Statement {

    public Variable() {
        super();
    }

    public Truth getTruth() {
        return new Truth(false);
    }
}