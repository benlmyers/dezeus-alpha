package Dezeus.Logic;

import Dezeus.Core.*;

public class Cond extends Statement {

    private Statement ant, cons;

    public Cond(Statement ant, Statement cons) {
        this.ant = ant;
        this.cons = cons;
    }

    public Cond(Statement conditional) {
        Deduction deduction = conditional.dezeus();
        this.ant = deduction.getAssumptions().toStatement();
        this.cons = deduction.getKnowns().toStatement();
    }

    public int logicalSize() {
        return ant.logicalSize() + cons.logicalSize();
    }

    public Truth getTruth() {
        return Truth.cond(ant.getTruth(), cons.getTruth());
    }

    @Override
    public Statements getChildren() {
        return new Statements(ant, cons);
    }

    @Override
    public Deduction dezeus() {
        return new Deduction(new Statements(), new Statements(ant));
    }

    public String toString() {
        return ant.groupedString() + " => " + cons.groupedString();
    }
}