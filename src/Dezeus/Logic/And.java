package Dezeus.Logic;

import Dezeus.Core.*;

public class And extends Statement {

    private Statement a, b;

    public And(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public int logicalSize() {
        return a.logicalSize() + b.logicalSize();
    }

    public Truth getTruth() {
        return Truth.and(a.getTruth(), b.getTruth());
    }

    public Statements dezeus() {
        return new Statements(a, b);
    }
}