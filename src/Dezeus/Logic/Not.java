package Dezeus.Logic;

import Dezeus.Core.*;

public class Not extends Statement {

    private Statement a;

    public Not(Statement a) {
        this.a = a;
    }

    public int logicalSize() {
        return a.logicalSize();
    }

    public Truth getTruth() {
        return Truth.not(a.getTruth());
    }

    public String toString() {
        return "!" + a.groupedString();
    }
}
