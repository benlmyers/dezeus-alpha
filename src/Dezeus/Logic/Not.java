package Dezeus.Logic;

import Dezeus.Core.*;

public class Not extends Statement {

    private Statement a;

    public Not(Statement a) {
        this.a = a;
    }

    public Truth getTruth() {
        return Truth.not(a.getTruth());
    }
}
