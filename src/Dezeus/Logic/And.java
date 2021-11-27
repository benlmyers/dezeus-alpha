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

    @Override
    public Statements getChildren() {
        return new Statements(a, b);
    }

    @Override
    public Deduction dezeus() {
        Statements statements = new Statements(a, b);
        return new Deduction(statements);
    }

    public String toString() {
        return a.groupedString() + " /\\ " + b.groupedString();
    }
}