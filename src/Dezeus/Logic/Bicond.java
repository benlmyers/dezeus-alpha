package Dezeus.Logic;

import Dezeus.Core.*;

public class Bicond {

    private Statement a, b;

    public Bicond(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public Truth getTruth() {
        return Truth.bicond(a.getTruth(), b.getTruth());
    }
}
