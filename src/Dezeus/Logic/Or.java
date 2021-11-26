package Dezeus.Logic;

import Dezeus.Core.*;

public class Or extends Statement {
    
    private Statement a, b;

    public Or(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public Truth getTruth() {
        return Truth.or(a.getTruth(), b.getTruth());
    }
}
