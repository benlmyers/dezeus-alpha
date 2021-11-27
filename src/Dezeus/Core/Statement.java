package Dezeus.Core;

import java.util.Set;

import Dezeus.Logic.*;

public abstract class Statement {

    public abstract Truth getTruth();

    // Deduction Methods

    public Statements dezeus() {
        return new Statements(this);
    }

    // Utility Methods

    public abstract int logicalSize();

    // Convenience Methods - Logic

    public Statement and(Statement b) {
        return new And(this, b);
    }

    public Statement or(Statement b) {
        return new Or(this, b);
    }

    public Statement not() {
        return new Not(this);
    }

    public Statement given(Statement ant) {
        return new Cond(ant, this);
    }

    public Statement implies(Statement cons) {
        return new Cond(this, cons);
    }

    public Statement iff(Statement b) {
        return new Bicond(this, b);
    }
}