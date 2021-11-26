package Dezeus.Logic;

import Dezeus.Core.*;

public class And extends Statement {

    private Statement a, b;

    public And(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public Truth getTruth() {
        return Truth.and(a.getTruth(), b.getTruth());
    }
}