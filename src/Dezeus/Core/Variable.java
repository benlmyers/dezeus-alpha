package Dezeus.Core;

public class Variable extends Statement {

    public Variable() {
        super();
    }

    public int logicalSize() {
        return 1;
    }

    public Truth getTruth() {
        return new Truth(false);
    }

    public Statements dezeus() {
        return new Statements(this);
    }
}