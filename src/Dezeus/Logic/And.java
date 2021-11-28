package Dezeus.Logic;

import java.util.Set;

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

    public Truth getTruth(Set<Variable> props) {
        return Truth.and(a.getTruth(props), b.getTruth(props));
    }

    @Override
    public Statements getChildren() {
        return new Statements(a, b);
    }

    @Override
    public Deduction getDeduction() {
        Statements statements = new Statements(a, b);
        return new Deduction(statements);
    }

    public String toString() {
        return a.groupedString() + " /\\ " + b.groupedString();
    }
}