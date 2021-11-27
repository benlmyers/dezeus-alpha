package Dezeus.Logic;

import Dezeus.Core.*;

public class Bicond extends Statement {

    private Statement a, b;

    public Bicond(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public int logicalSize() {
        return a.logicalSize() + b.logicalSize();
    }

    public Truth getTruth() {
        return Truth.bicond(a.getTruth(), b.getTruth());
    }

    public String toString() {
        return a.groupedString() + " <=> " + b.groupedString();
    }
}
