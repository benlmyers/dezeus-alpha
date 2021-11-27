package Dezeus.Logic;

import Dezeus.Core.*;

public class Cond extends Statement {

    private Statement ant, cons;

    public Cond(Statement ant, Statement cons) {
        this.ant = ant;
        this.cons = cons;
    }

    public int logicalSize() {
        return ant.logicalSize() + cons.logicalSize();
    }

    public Truth getTruth() {
        return Truth.cond(ant.getTruth(), cons.getTruth());
    }

    @Override
    public Deduction dezeus() {
        return new Deduction(new Statements(ant), new Statements(cons));
    }
}