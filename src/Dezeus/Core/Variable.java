package Dezeus.Core;

public class Variable implements Statement {

    public Variable() {
        super();
    }

    @Override
    public Truth getTruth() {
        return new Truth(false);
    }
}