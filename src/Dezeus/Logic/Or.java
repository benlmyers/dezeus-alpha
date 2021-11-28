package Dezeus.Logic;

import java.util.Set;

import Dezeus.Core.*;

public class Or extends Statement {

    private Statement a, b;

    public Or(Statement a, Statement b) {
        this.a = a;
        this.b = b;
    }

    public int logicalSize() {
        return a.logicalSize() + b.logicalSize();
    }

    public Truth getTruth(Set<Variable> props) {
        return Truth.or(a.getTruth(props), b.getTruth(props));
    }

    public String toString() {
        return a.groupedString() + " \\/ " + b.groupedString();
    }

    @Override
    public Statements getChildren() {
        return new Statements(a, b);
    }
}
